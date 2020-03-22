package com.patterns.decorator.notificator.decorator;

import com.patterns.decorator.notificator.Notifier;

public class BaseDecorator implements Notifier {

    private Notifier notifier;

    BaseDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void sendMessage(String message) {
        notifier.sendMessage(message);
    }
}
