package com.patterns.iterator.notifier;

import com.patterns.iterator.iterator.Iterator;
import com.patterns.iterator.model.Profile;
import com.patterns.iterator.networks.SocialNetwork;

import java.util.List;

/**
 * @author Elina Valieva on 16.03.2020
 */
public class SocialNotifier {

    private SocialNetwork socialNetwork;

    public SocialNotifier(SocialNetwork socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    public void sendMessageToFriends(List<String> profileEmail, String message) {
        System.out.println("\nIterating over friends...\n");
        Iterator iterator = socialNetwork.createFriendsIterator(profileEmail);
        while (iterator.hasNext()) {
            Profile profile = iterator.getNext();
            sendMessage(profile.getName(), profile.getEmail(), message);
        }
    }

    public void sendMessageToCoworkers(List<String> profileEmail, String message) {
        System.out.println("\nIterating over coworkers...\n");
        Iterator iterator = socialNetwork.createCoworkersIterator(profileEmail);
        while (iterator.hasNext()) {
            Profile profile = iterator.getNext();
            sendMessage(profile.getName(), profile.getEmail(), message);
        }
    }

    private void sendMessage(String name, String email, String message) {
        System.out.println("Sent " + name + " message to: '" + email + "'. Message body: '" + message + "'");
    }
}
