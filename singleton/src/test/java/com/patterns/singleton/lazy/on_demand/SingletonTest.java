package com.patterns.singleton.lazy.on_demand;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingletonTest {

    @Test
    public void getInstance() {
        Singleton instance = Singleton.getInstance();
        Assert.assertSame(instance, Singleton.getInstance());
    }
}