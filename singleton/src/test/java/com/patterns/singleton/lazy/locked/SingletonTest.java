package com.patterns.singleton.lazy.locked;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class SingletonTest {

    @Test
    public void getInstance() {
        Singleton singleton = Singleton.getInstance();
        Singleton anotherSingleton = Singleton.getInstance();

        assertSame(singleton, anotherSingleton);
        assertEquals(singleton, anotherSingleton);
    }
}