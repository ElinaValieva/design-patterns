package com.patterns.facade.parser;

/**
 * @author Elina Valieva on 19.03.2020
 */
public class AudioMixer {

    public String mix(String codec) {
        return String.format("Mixed %s", codec);
    }
}
