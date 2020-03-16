package com.patterns.iterator.networks;

import com.patterns.iterator.iterator.FacebookIterator;
import com.patterns.iterator.model.Profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static javax.swing.UIManager.put;

/**
 * @author Elina Valieva on 16.03.2020
 */
public class Facebook implements SocialNetwork {

    @Override
    public List<Profile> loadProfiles() {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("A", "email-1.ru", new LinkedHashMap<Profile.ProfileType, List<String>>() {{
            put(Profile.ProfileType.COWORKERS, Arrays.asList("email-2.ru", "email-3.ru"));
            put(Profile.ProfileType.FRIENDS, Arrays.asList("email-4.ru", "email-5.ru"));
        }}));
        profiles.add(new Profile("B", "email-2.ru", new LinkedHashMap<Profile.ProfileType, List<String>>() {{
            put(Profile.ProfileType.COWORKERS, Arrays.asList("email-3.ru", "email-4.ru"));
        }}));
        profiles.add(new Profile("C", "email-3.ru", new LinkedHashMap<Profile.ProfileType, List<String>>() {{
            put(Profile.ProfileType.COWORKERS, Arrays.asList("email-2.ru", "email-5.ru"));
        }}));
        profiles.add(new Profile("D", "email-4.ru", new LinkedHashMap<Profile.ProfileType, List<String>>() {{
            put(Profile.ProfileType.COWORKERS, Arrays.asList("email-2.ru", "email-3.ru"));
        }}));
        return profiles;
    }

    @Override
    public FacebookIterator createFriendsIterator(List<String> profileEmails) {
        return new FacebookIterator(this, Profile.ProfileType.FRIENDS);
    }

    @Override
    public FacebookIterator createCoworkersIterator(List<String> profileEmails) {
        return new FacebookIterator(this, Profile.ProfileType.COWORKERS);
    }
}
