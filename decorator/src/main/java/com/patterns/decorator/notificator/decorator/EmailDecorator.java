package com.patterns.decorator.notificator.decorator;

import com.patterns.decorator.notificator.Notifier;

public class EmailDecorator extends BaseDecorator {

    public EmailDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void sendMessage(String message) {
        super.sendMessage(message);
        System.out.println("Email: " + message);
    }
}
