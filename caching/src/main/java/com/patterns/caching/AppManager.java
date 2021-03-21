package com.patterns.caching;

import com.patterns.caching.cache.CachePolicy;
import com.patterns.caching.model.User;

public class AppManager {

    private static CachePolicy cachePolicy;

    public static void initCacheCapacity(Integer capacity) {
        CacheManager.initCapacity(capacity);
    }

    public static User get(String id) {
        if (cachePolicy == CachePolicy.BEHIND)
            return CacheManager.readThroughBackPolicy(id);
        if (cachePolicy == CachePolicy.AROUND || cachePolicy == CachePolicy.THROUGH)
            return CacheManager.readThrough(id);
        if (cachePolicy == CachePolicy.ASIDE)
            return CacheManager.readAside(id);
        return null;
    }

    public static void save(User user) {
        if (cachePolicy == CachePolicy.BEHIND)
            CacheManager.writeBehind(user);
        if (cachePolicy == CachePolicy.THROUGH)
            CacheManager.writeThrough(user);
        if (cachePolicy == CachePolicy.AROUND)
            CacheManager.writeAround(user);
        else CacheManager.writeAside(user);
    }
}
