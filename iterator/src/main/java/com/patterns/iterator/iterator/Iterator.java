package com.patterns.iterator.iterator;

import com.patterns.iterator.model.Profile;

public interface Iterator {

    boolean hasNext();

    Profile getNext();

    void reset();
}
