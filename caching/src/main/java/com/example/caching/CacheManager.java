package com.example.caching;

import com.example.caching.cache.Cache;
import com.example.caching.cache.LruCache;
import com.example.caching.database.DatabaseManager;
import com.example.caching.model.User;

import java.util.Optional;


public class CacheManager {

    private static Cache cache;

    public static void initCapacity(Integer capacity) {
        if (cache == null)
            cache = new LruCache(capacity);
        else cache.setCapacity(capacity);
    }

    public static User readThrough(String id) {
        if (cache.contains(id)) {
            return cache.get(id);
        }
        User user = DatabaseManager.selectById(id);
        cache.set(id, user);
        return user;
    }

    public static User readThroughBackPolicy(String id) {
        if (cache.contains(id))
            return cache.get(id);
        User user = DatabaseManager.selectById(id);
        if (cache.isFull()) {
            User cacheLru = cache.getLru();
            DatabaseManager.update(cacheLru);
        }
        cache.set(id, user);
        return user;
    }

    public static User readAside(String id) {
        if (cache.contains(id))
            return cache.get(id);
        User user = DatabaseManager.selectById(id);
        Optional.ofNullable(user).ifPresent(e -> cache.set(id, e));
        return user;
    }

    public static void writeThrough(User user) {
        if (cache.contains(user.getId())) {
            DatabaseManager.update(user);
        } else DatabaseManager.insert(user);
        cache.set(user.getId(), user);
    }

    public static void writeAround(User user) {
        if (cache.contains(user.getId())) {
            DatabaseManager.update(user);
            cache.invalidate(user.getId());
        } else DatabaseManager.insert(user);
    }

    public static void writeBehind(User user) {
        if (cache.isFull() && !cache.contains(user.getId())) {
            User cacheLru = cache.getLru();
            DatabaseManager.update(cacheLru);
        }
        cache.set(user.getId(), user);
    }

    public static void writeAside(User user) {
        DatabaseManager.update(user);
        cache.invalidate(user.getId());
    }

    public static void clear() {
        cache.clear();
    }

    public static void flush() {
        cache.getCache().parallelStream()
                .forEach(DatabaseManager::update);
    }
}
