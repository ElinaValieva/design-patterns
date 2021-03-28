package com.patterns.caching.cache;

import com.patterns.caching.database.Database;
import com.patterns.caching.model.BaseModel;

import java.util.Collections;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class CacheManager<T extends BaseModel> {

    private static Logger log = Logger.getLogger(CacheManager.class.getName());

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
            log.info("Read through cache");
            return cache.get(id);
        }
        log.info("Read through database");
        T entity = databaseManager.selectById(id);
        log.info("Update cache");
        cache.set(id, entity);
        return entity;
    }

    public T readThroughBackPolicy(String id) {
        if (cache.contains(id)) {
            log.info("Read from cache");
            return cache.get(id);
        }
        T entity = databaseManager.selectById(id);
        if (cache.isFull()) {
            log.info("Cache is full - update lru in database");
            T cacheLru = cache.getLru();
            databaseManager.update(cacheLru);
        }
        log.info("Update cache");
        cache.set(id, entity);
        return entity;
    }

    public T readAside(String id) {
        if (cache.contains(id)) {
            log.info("Read from cache");
            return cache.get(id);
        }
        log.info("Set entity to cache");
        T entity = databaseManager.selectById(id);
        Optional.ofNullable(entity).ifPresent(e -> cache.set(id, e));
        return entity;
    }

    public void writeThrough(T entity) {
        if (cache.contains(entity.getId())) {
            log.info("Update entity in database");
            databaseManager.update(entity);
        } else {
            log.info("Add entity to database");
            databaseManager.insert(entity);
        }
        cache.set(entity.getId(), entity);
    }

    public void writeAround(T entity) {
        if (cache.contains(entity.getId())) {
            log.info("Update entity in database");
            databaseManager.update(entity);
            log.info("Invalidate cache");
            cache.invalidate(entity.getId());
        } else {
            log.info("Add entity to database");
            databaseManager.insert(entity);
        }
    }

    public void writeBehind(T entity) {
        if (cache.isFull() && !cache.contains(entity.getId())) {
            log.info("Cache is full and doesn't contain entity");
            T cacheLru = cache.getLru();
            log.info("Update lru entity in database");
            databaseManager.update(cacheLru);
        }
        log.info("Update cache");
        cache.set(entity.getId(), entity);
    }

    public void writeAside(T entity) {
        log.info("Update database");
        databaseManager.update(entity);
        log.info("Invalidate cache");
        cache.invalidate(entity.getId());
    }

    public void clear() {
        cache.clear();
    }

    public void flush() {
        cache.getCache().parallelStream()
                .forEach(databaseManager::update);
    }

    public String print() {
        return Optional.ofNullable(cache)
                .map(e -> cache.getCache())
                .orElse(Collections.emptyList())
                .stream()
                .map(userAccount -> userAccount.toString() + "\n")
                .collect(Collectors.joining("", "\n--CACHE CONTENT--\n", "----\n"));
    }
}
