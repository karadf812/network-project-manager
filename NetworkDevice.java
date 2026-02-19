package com.networkmanager.models;

public class NetworkDevice {

    private String type;
    private String ip;

    public NetworkDevice(String type, String ip) {
        this.type = type;
        this.ip = ip;
    }

    public String getType() { return type; }
    public String getIp() { return ip; }
}
