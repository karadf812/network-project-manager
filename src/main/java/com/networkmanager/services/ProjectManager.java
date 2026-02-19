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
	    	System.out.println("3. Delete Project");
  	    	System.out.println("4. Exit");


            int choice;

		try {
    			choice = Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
    			System.out.println("Please enter a number.");
    			continue;
		}


            switch(choice) {
		case 1: createProject(); break;
 		case 2: showProjects(); break;
    		case 3: deleteProject(); break;
    		case 4: return;
		}

        }
    }

    private void createProject() {
    	System.out.print("Enter project name: ");
    	String name = scanner.nextLine();

    	NetworkProject project = new NetworkProject(name);

    	System.out.print("Enter subnet (e.g. 192.168.10.0): ");
    	String subnet = scanner.nextLine();
    	project.addSubnet(new Subnet(subnet));

    	System.out.print("Enter router IP: ");
    	String ip = scanner.nextLine();
    	project.addDevice(new NetworkDevice("Router", ip));

    while(true) {
	System.out.print("Enter service (DHCP/DNS/HTTP/FTP) or type done: ");
    	String service = scanner.nextLine();

    	if(service.equalsIgnoreCase("done"))
        	break;

    	project.addService(new NetworkService(service, "Running"));
}


    	projects.add(project);
    	System.out.println("Project added.");
}

    private void showProjects() {
        for(NetworkProject p : projects) {
            p.showDetails();
        }
    }
	private void deleteProject() {

	if(projects.isEmpty()) {
        	System.out.println("No projects to delete.");
        	return;
    	}

    	for(int i = 0; i < projects.size(); i++) {
        	System.out.println(i + ": " + projects.get(i).getName());
    	}

    	System.out.print("Enter project number to delete: ");

    	int index;

    	try {
        	index = Integer.parseInt(scanner.nextLine());
    	} catch (Exception e) {
        	System.out.println("Please enter a valid number.");
        	return;
    	}

    	if(index >= 0 && index < projects.size()) {
        	projects.remove(index);
        	System.out.println("Project deleted.");
    	} else {
        	System.out.println("Invalid index.");
    	}
}


}

