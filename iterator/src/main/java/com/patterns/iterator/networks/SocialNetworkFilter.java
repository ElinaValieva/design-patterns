package com.patterns.iterator.networks;

import com.patterns.iterator.model.Profile;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Elina Valieva on 16.03.2020
 */
public class SocialNetworkFilter {

    protected Profile createProfileWithProfileType(Profile profile, Profile.ProfileType profileType) {
        Map<Profile.ProfileType, List<String>> contacts = profile.getFriends().entrySet().stream()
                                                                 .filter(profileTypeListEntry -> profileTypeListEntry.getKey()
                                                                                                                     .equals(profileType))
                                                                 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        if (contacts.isEmpty())
            return null;

        return new Profile(profile.getName(), profile.getEmail(), contacts);
    }
}
