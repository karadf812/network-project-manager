package com.networkmanager;

import com.networkmanager.services.ProjectManager;

public class App {
    public static void main(String[] args) {
        ProjectManager manager = new ProjectManager();
        manager.start();
    }
}
