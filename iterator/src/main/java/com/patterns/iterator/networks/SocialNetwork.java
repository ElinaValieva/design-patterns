package com.patterns.iterator.networks;

import com.patterns.iterator.iterator.Iterator;
import com.patterns.iterator.model.Profile;

import java.util.List;

/**
 * @author Elina Valieva on 16.03.2020
 */
public interface SocialNetwork {

    List<Profile> loadProfiles();

    Iterator createFriendsIterator(List<String> profileEmails);

    Iterator createCoworkersIterator(List<String> profileEmails);
}
