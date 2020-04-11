package com.patterns.singleton.lazy.on_demand;

class Singleton {

    public static class SingletonHolder {
        static final Singleton HOLDER_INSTANCE = new Singleton();
    }

    static Singleton getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
}
