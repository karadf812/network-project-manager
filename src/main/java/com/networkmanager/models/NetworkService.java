package com.networkmanager.models;

public class NetworkService {

    private String name;
    private String status;

    public NetworkService(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}

