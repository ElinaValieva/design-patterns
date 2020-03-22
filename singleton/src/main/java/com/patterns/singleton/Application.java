package com.patterns.singleton;

public class Application {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton anotherSingleton = Singleton.getInstance();

        System.out.println(singleton.equals(anotherSingleton) && singleton == anotherSingleton);
    }
}
