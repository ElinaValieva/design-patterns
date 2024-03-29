package com.patterns.caching;

import com.patterns.caching.cache.CacheManager;
import com.patterns.caching.cache.CachePolicy;
import com.patterns.caching.database.Database;
import com.patterns.caching.model.BaseModel;

public class AppManager<T extends BaseModel> {

    private CachePolicy cachePolicy;
    private final CacheManager<T> cacheManager;

    public AppManager(Database<T> databaseManager, CachePolicy cachePolicy) {
        this.cacheManager = new CacheManager<>(databaseManager);
        this.cachePolicy = cachePolicy;
    }

    public AppManager(Database<T> databaseManager) {
        this.cacheManager = new CacheManager<>(databaseManager);
    }

    public void setCachePolicy(CachePolicy cachePolicy) {
        this.cachePolicy = cachePolicy;
    }

    public void initCacheCapacity(Integer capacity) {
        cacheManager.initCapacity(capacity);
    }

    public T get(String id) {
        if (cachePolicy == CachePolicy.BEHIND)
            return cacheManager.readThroughBackPolicy(id);
        if (cachePolicy == CachePolicy.AROUND || cachePolicy == CachePolicy.THROUGH)
            return cacheManager.readThrough(id);
        if (cachePolicy == CachePolicy.ASIDE)
            return cacheManager.readAside(id);
        return null;
    }

    public void save(T entity) {
        if (cachePolicy == CachePolicy.BEHIND)
            cacheManager.writeBehind(entity);
        if (cachePolicy == CachePolicy.THROUGH)
            cacheManager.writeThrough(entity);
        if (cachePolicy == CachePolicy.AROUND)
            cacheManager.writeAround(entity);
        else cacheManager.writeAside(entity);
    }

    public String printCacheContent() {
        return cacheManager.print();
    }
}
