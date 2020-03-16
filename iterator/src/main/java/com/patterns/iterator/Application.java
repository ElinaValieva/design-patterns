package com.patterns.iterator;

import com.patterns.iterator.networks.LinkedIn;
import com.patterns.iterator.networks.SocialNetwork;
import com.patterns.iterator.notifier.SocialNotifier;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        SocialNetwork socialNetwork = new LinkedIn();
        SocialNotifier socialNotifier = new SocialNotifier(socialNetwork);
        socialNotifier.sendMessageToFriends(getNotifiedProfiles(), "Hey! This is friend notification");
        socialNotifier.sendMessageToCoworkers(getNotifiedProfiles(), "Hey! This is coworkers notification");
    }

    private static List<String> getNotifiedProfiles() {
        return Arrays.asList("email-1.ru", "email-2.ru");
    }
}
