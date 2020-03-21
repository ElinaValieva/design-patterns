package com.patterns.bridge.device;

public interface Device {

    boolean isEnabled();

    void enable();

    void disable();

    Integer getVolume();

    void setVolume(Integer volume);

    Integer getChanel();

    void setChanel(Integer chanel);
}
