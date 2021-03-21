package com.patterns.caching.cache;

import java.util.List;

public interface Cache<T> {

    T get(String id);

    T getLru();

    List<T> getCache();

    boolean contains(String id);

    boolean isFull();

    void set(String id, T user);

    void setCapacity(Integer capacity);

    void invalidate(String id);

    void clear();
}
