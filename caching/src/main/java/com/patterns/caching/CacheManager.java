package com.patterns.caching;

import com.patterns.caching.cache.Cache;
import com.patterns.caching.cache.LruCache;
import com.patterns.caching.database.Database;
import com.patterns.caching.model.BaseModel;

import java.util.Optional;


public class CacheManager<T extends BaseModel> {

    private Cache<T> cache;
    private final Database<T> databaseManager;
    private static final int DEFAULT_CAPACITY = 10;

    public CacheManager(Database<T> databaseManager) {
        this.databaseManager = databaseManager;
        initCapacity(DEFAULT_CAPACITY);
    }

    public void initCapacity(Integer capacity) {
        if (cache == null)
            cache = new LruCache<T>(capacity);
        else cache.setCapacity(capacity);
    }

    public T readThrough(String id) {
        if (cache.contains(id)) {
            return cache.get(id);
        }
        T entity = databaseManager.selectById(id);
        cache.set(id, entity);
        return entity;
    }

    public T readThroughBackPolicy(String id) {
        if (cache.contains(id))
            return cache.get(id);
        T entity = databaseManager.selectById(id);
        if (cache.isFull()) {
            T cacheLru = cache.getLru();
            databaseManager.update(cacheLru);
        }
        cache.set(id, entity);
        return entity;
    }

    public T readAside(String id) {
        if (cache.contains(id))
            return cache.get(id);
        T entity = databaseManager.selectById(id);
        Optional.ofNullable(entity).ifPresent(e -> cache.set(id, e));
        return entity;
    }

    public void writeThrough(T entity) {
        if (cache.contains(entity.getId())) {
            databaseManager.update(entity);
        } else databaseManager.insert(entity);
        cache.set(entity.getId(), entity);
    }

    public void writeAround(T entity) {
        if (cache.contains(entity.getId())) {
            databaseManager.update(entity);
            cache.invalidate(entity.getId());
        } else databaseManager.insert(entity);
    }

    public void writeBehind(T entity) {
        if (cache.isFull() && !cache.contains(entity.getId())) {
            T cacheLru = cache.getLru();
            databaseManager.update(cacheLru);
        }
        cache.set(entity.getId(), entity);
    }

    public void writeAside(T entity) {
        databaseManager.update(entity);
        cache.invalidate(entity.getId());
    }

    public void clear() {
        cache.clear();
    }

    public void flush() {
        cache.getCache().parallelStream()
                .forEach(databaseManager::update);
    }
}
