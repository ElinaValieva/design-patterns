package com.example.caching.database;

import com.example.caching.model.User;

import java.util.HashMap;
import java.util.Map;

public class DatabaseManager {

    private static Map<String, User> dictionary = new HashMap<>();

    public static User selectById(String id) {
        return dictionary.get(id);
    }

    public static User update(User user) {
        return dictionary.put(user.getId(), user);
    }

    public static User insert(User user) {
        return dictionary.putIfAbsent(user.getId(), user);
    }
}
