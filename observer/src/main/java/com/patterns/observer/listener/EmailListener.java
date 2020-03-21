package com.patterns.observer.listener;

public class EmailListener implements EventListener {

    @Override
    public void notify(String data) {
        System.out.println(String.format("Performing sending email: %s", data));
    }
}
