package com.patterns.bridge.device;

public class Radio implements Device {

    private boolean enabled = false;
    private Integer volume = 0;
    private Integer chanel = 0;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        this.enabled = true;
    }

    @Override
    public void disable() {
        this.enabled = false;
    }

    @Override
    public Integer getVolume() {
        return volume;
    }

    @Override
    public void setVolume(Integer volume) {
        this.volume = volume * 10;
    }

    @Override
    public Integer getChanel() {
        return chanel;
    }

    @Override
    public void setChanel(Integer chanel) {
        this.chanel = chanel + 100;
    }
}
