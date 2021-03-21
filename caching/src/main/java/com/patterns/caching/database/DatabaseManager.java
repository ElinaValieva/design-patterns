package com.patterns.caching.database;

import com.patterns.caching.model.BaseModel;

import java.util.HashMap;
import java.util.Map;

public class DatabaseManager<T extends BaseModel> {

    private Map<String, T> dictionary = new HashMap<>();

    public T selectById(String id) {
        return dictionary.get(id);
    }

    public T update(T user) {
        return dictionary.put(user.getId(), user);
    }

    public T insert(T user) {
        return dictionary.putIfAbsent(user.getId(), user);
    }
}
