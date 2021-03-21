package com.patterns.caching.cache;

import com.patterns.caching.model.User;

import java.util.List;

public interface Cache {

    User get(String id);

    User getLru();

    List<User> getCache();

    boolean contains(String id);

    boolean isFull();

    void set(String id, User user);

    void setCapacity(Integer capacity);

    void invalidate(String id);

    void clear();
}
