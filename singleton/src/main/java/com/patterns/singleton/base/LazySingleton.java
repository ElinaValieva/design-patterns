package com.patterns.singleton.base;

public class LazySingleton {

    static class Singleton {
        static final Singleton INSTANCE = new Singleton();
    }

    enum SingletonEnum {
        INSTANCE
    }
}
