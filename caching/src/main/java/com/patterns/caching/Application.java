package com.patterns.caching;

import com.patterns.caching.cache.CachePolicy;
import com.patterns.caching.config.ConfigReader;
import com.patterns.caching.database.Database;
import com.patterns.caching.database.DatabaseManager;
import com.patterns.caching.model.User;

import java.util.logging.Logger;

import static com.patterns.caching.cache.CachePolicy.ASIDE;


public class Application {

    private static final Logger log = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {
        ConfigReader configReader = new ConfigReader();
        Database<User> database = new DatabaseManager<>(User.class, configReader);
        AppManager<User> appManager = new AppManager<>(database);
        useReadAndWriteThroughStrategy(appManager);
        useReadThroughAndWriteAroundStrategy(appManager);
        useReadThroughAndWriteBehindStrategy(appManager);
        useCacheAsideStategy(appManager);
    }

    /**
     * Read-through and write-through.
     */
    private static void useReadAndWriteThroughStrategy(AppManager<User> appManager) {
        log.info("# CachingPolicy.THROUGH");
        appManager.setCachePolicy(CachePolicy.THROUGH);
        appManager.initCacheCapacity(3);
        appManager.save(new User("001", "A", "Description A"));
        log.info(appManager.printCacheContent());
        appManager.get("001");
        appManager.get("001");
    }

    /**
     * Read-through and write-around.
     */
    private static void useReadThroughAndWriteAroundStrategy(AppManager<User> appManager) {
        log.info("# CachingPolicy.AROUND");
        appManager.setCachePolicy(CachePolicy.AROUND);

        appManager.save(new User("002", "B", "Description B"));
        log.info(appManager.printCacheContent());
        User foundedUser = appManager.get("002");
        foundedUser.setName("New B");
        appManager.save(foundedUser);
        log.info(appManager.printCacheContent());
        appManager.get("002");
        log.info(appManager.printCacheContent());
        appManager.get("002");
    }

    /**
     * Read-through and write-behind.
     */
    private static void useReadThroughAndWriteBehindStrategy(AppManager<User> appManager) {
        log.info("# CachingPolicy.BEHIND");
        appManager.setCachePolicy(CachePolicy.BEHIND);

        appManager.save(new User("003", "Adam", "He likes food."));
        appManager.save(new User("004", "Rita", "She hates cats."));
        appManager.save(new User("005", "Isaac", "He is allergic to mustard."));
        log.info(appManager.printCacheContent());
        appManager.get("003");
        log.info(appManager.printCacheContent());
        User userAccount6 = new User("006", "Yasha", "She is an only child.");
        appManager.save(userAccount6);
        log.info(appManager.printCacheContent());
        appManager.get("004");
        log.info(appManager.printCacheContent());
    }

    /**
     * Cache-Aside.
     */
    private static void useCacheAsideStategy(AppManager<User> appManager) {
        log.info("# CachingPolicy.ASIDE");
        appManager.setCachePolicy(ASIDE);
        log.info(appManager.printCacheContent());

        appManager.save(new User("003", "Adam", "He likes food."));
        appManager.save(new User("004", "Rita", "She hates cats."));
        appManager.save(new User("005", "Isaac", "He is allergic to mustard."));

        log.info(appManager.printCacheContent());
        appManager.get("003");
        log.info(appManager.printCacheContent());
        appManager.get("004");
        log.info(appManager.printCacheContent());
    }
}
