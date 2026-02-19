package com.networkmanager.services;

import com.networkmanager.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectManager {

    private List<NetworkProject> projects = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {

        while(true) {

            System.out.println("\n--- Network Project Manager ---");
            System.out.println("1. Add Project");
            System.out.println("2. Show Projects");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1: createProject(); break;
                case 2: showProjects(); break;
                case 3: return;
            }
        }
    }

    private void createProject() {
        System.out.print("Enter project name: ");
        String name = scanner.nextLine();

        NetworkProject project = new NetworkProject(name);

        project.addSubnet(new Subnet("192.168.10.0"));
        project.addDevice(new NetworkDevice("Router", "192.168.10.1"));
        project.addService(new NetworkService("DHCP", "Running"));

        projects.add(project);
        System.out.println("Project added.");
    }

    private void showProjects() {
        for(NetworkProject p : projects) {
            p.showDetails();
        }
    }
}
