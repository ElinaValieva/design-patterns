package com.patterns.iterator.iterator;

import com.patterns.iterator.model.Profile;
import com.patterns.iterator.networks.Facebook;
import com.patterns.iterator.networks.SocialNetworkFilter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Elina Valieva on 16.03.2020
 */
public class FacebookIterator extends SocialNetworkFilter implements Iterator {

    private Integer currentPosition;

    private List<Profile> profiles;

    public FacebookIterator(Facebook facebook, Profile.ProfileType profileType) {
        this.profiles = facebook.loadProfiles().stream()
                                .map(profile -> createProfileWithProfileType(profile, profileType))
                                .filter(Objects::nonNull)
                                .collect(Collectors.toList());
        reset();
    }

    @Override
    public boolean hasNext() {
        return currentPosition < profiles.size();
    }

    @Override
    public Profile getNext() {
        if (!hasNext())
            return null;
        Profile profile = profiles.get(currentPosition);
        currentPosition++;
        return profile;
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}
