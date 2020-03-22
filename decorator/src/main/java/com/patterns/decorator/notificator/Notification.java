package com.patterns.decorator.notificator;

public class Notification implements Notifier {

    @Override
    public void sendMessage(String message) {
        System.out.println(message);
    }
}
