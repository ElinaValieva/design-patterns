package com.patterns.bridge.device;

public class TV implements Device {

    private Integer volume = 0;
    private Integer chanel = 0;

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void enable() {

    }

    @Override
    public void disable() {

    }

    @Override
    public Integer getVolume() {
        return volume;
    }

    @Override
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @Override
    public Integer getChanel() {
        return chanel;
    }

    @Override
    public void setChanel(Integer chanel) {
        this.chanel = chanel;
    }
}
