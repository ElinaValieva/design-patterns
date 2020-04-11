package com.patterns.singleton.base;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class LazySingletonTest {

    @Test
    public void getInstance() {
        LazySingleton.Singleton instance = LazySingleton.Singleton.INSTANCE;
        assertSame(instance, LazySingleton.Singleton.INSTANCE);
        LazySingleton.SingletonEnum singletonEnum = LazySingleton.SingletonEnum.INSTANCE;
        assertSame(singletonEnum, LazySingleton.SingletonEnum.INSTANCE);
    }

}