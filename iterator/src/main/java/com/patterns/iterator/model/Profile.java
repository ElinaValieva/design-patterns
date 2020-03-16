package com.patterns.iterator.model;

import java.util.List;
import java.util.Map;

/**
 * @author Elina Valieva on 16.03.2020
 */
public class Profile {

    private String name;

    private String email;

    private Map<ProfileType, List<String>> friends;

    public Profile(String name, String email, Map<ProfileType, List<String>> friends) {
        this.name = name;
        this.email = email;
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Map<ProfileType, List<String>> getFriends() {
        return friends;
    }

    public enum ProfileType {
        COWORKERS, FRIENDS
    }
}
