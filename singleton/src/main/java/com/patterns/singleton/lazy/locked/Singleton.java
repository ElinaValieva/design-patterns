package com.patterns.singleton.lazy.locked;

class Singleton {

    private static Singleton singleton;

    private Singleton() {
    }

    static synchronized Singleton getInstance() {
        if (singleton == null)
            singleton = new Singleton();

        return singleton;
    }
}
