package com.patterns.caching;

import com.patterns.caching.cache.CachePolicy;
import com.patterns.caching.database.Database;
import com.patterns.caching.database.DatabaseManager;
import com.patterns.caching.model.User;

public class Application {

    public static void main(String[] args) {
        Database<User> database = new DatabaseManager<>(User.class, false);
        AppManager<User> appManager = new AppManager<>(database, CachePolicy.AROUND);
        appManager.initCacheCapacity(3);
        appManager.save(new User("1", "A", "Description A"));
        appManager.save(new User("2", "B", "Description B"));
        System.out.println(appManager.get("1"));
    }
}
