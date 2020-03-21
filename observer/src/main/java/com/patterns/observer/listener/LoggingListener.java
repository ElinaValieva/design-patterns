package com.patterns.observer.listener;

public class LoggingListener implements EventListener {

    @Override
    public void notify(String data) {
        System.out.println(String.format("Performing  logging: %s", data));
    }
}
