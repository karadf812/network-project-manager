package com.networkmanager.models;

import java.util.ArrayList;
import java.util.List;

public class NetworkProject {

    private String name;
    private List<Subnet> subnets = new ArrayList<>();
    private List<NetworkDevice> devices = new ArrayList<>();
    private List<NetworkService> services = new ArrayList<>();

    public NetworkProject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSubnet(Subnet subnet) {
        subnets.add(subnet);
    }

    public void addDevice(NetworkDevice device) {
        devices.add(device);
    }

    public void addService(NetworkService service) {
        services.add(service);
    }

    public void showDetails() {
        System.out.println("Project: " + name);

        System.out.println("Subnets:");
        for (Subnet s : subnets)
            System.out.println("- " + s.getNetwork());

        System.out.println("Devices:");
        for (NetworkDevice d : devices)
            System.out.println("- " + d.getType() + " (" + d.getIp() + ")");

        System.out.println("Services:");
        for (NetworkService s : services)
            System.out.println("- " + s.getName() + " [" + s.getStatus() + "]");
    }
}

