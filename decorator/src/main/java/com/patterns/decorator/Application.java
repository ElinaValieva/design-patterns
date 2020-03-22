package com.patterns.decorator;

import com.patterns.decorator.notificator.*;
import com.patterns.decorator.notificator.decorator.EmailDecorator;
import com.patterns.decorator.notificator.decorator.SlackDecorator;
import com.patterns.decorator.notificator.decorator.SmsDecorator;

public class Application {

    public static void main(String[] args) {
        Notifier notification = new Notification();
        Notifier slackDecorator = new SlackDecorator(notification);
        Notifier smsDecorator = new SmsDecorator(slackDecorator);
        Notifier emailDecorator = new EmailDecorator(smsDecorator);

        emailDecorator.sendMessage("Hello world!");
    }
}
