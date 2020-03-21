package com.patterns.bridge;

import com.patterns.bridge.device.Radio;
import com.patterns.bridge.device.TV;

import java.rmi.Remote;

public class Application {

    public static void main(String[] args) {
        RemoteDevice remoteDevice = new RemoteDevice(new TV());
        remoteDevice.chanelDown();
        remoteDevice.chanelUp();
        remoteDevice.volumeDown();
        remoteDevice.chanelUp();

        RemoteDevice remoteDeviceForRadio = new RemoteDevice(new Radio());
        remoteDeviceForRadio.chanelDown();
        remoteDeviceForRadio.chanelUp();
        remoteDeviceForRadio.volumeUp();
        remoteDeviceForRadio.togglePower();
    }
}
