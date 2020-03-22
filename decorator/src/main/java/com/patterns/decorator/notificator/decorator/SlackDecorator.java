package com.patterns.decorator.notificator.decorator;

import com.patterns.decorator.notificator.Notifier;

public class SlackDecorator extends BaseDecorator {

    public SlackDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void sendMessage(String message) {
        super.sendMessage(message);
        System.out.println("Slack: " + message);
    }
}
