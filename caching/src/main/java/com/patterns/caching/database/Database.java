package com.patterns.caching.database;

public interface Database<T> {

    T selectById(String id);

    void update(T user);

    void insert(T user);
}
