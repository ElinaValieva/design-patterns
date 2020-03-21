package com.patterns.bridge;

import com.patterns.bridge.device.Device;

class RemoteDevice {

    private Device device;

    RemoteDevice(Device device) {
        this.device = device;
    }

    void togglePower() {
        if (device.isEnabled())
            device.disable();
        else device.enable();
    }

    void volumeDown() {
        device.setVolume(device.getVolume() - 1);
    }

    void volumeUp() {
        device.setVolume(device.getVolume() + 1);
    }

    void chanelUp() {
        device.setChanel(device.getChanel() + 10);
    }

    void chanelDown() {
        device.setChanel(device.getChanel() - 10);
    }
}
