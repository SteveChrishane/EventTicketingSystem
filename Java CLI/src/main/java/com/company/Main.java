package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        Scanner input = new Scanner(System.in);
        Configuration config = new Configuration();

        // Load configuration or prompt for new one if there is no "config.json"
        // available
        if (!config.loadConfig() || !config.hasValidValues()) {
            config.configPrompt();
            config.saveConfig();
        } else {
            System.out.println("\nConfiguration loaded successfully.");
            Logger.log("Configuration loaded successfully.");
        }

        config.displayConfig();

        // Initialize the shared TicketPool with maxTicketCapacity
        TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity());
        ticketPool.addTickets(config.getTotalTickets());

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Simulate");
            System.out.println("2. Update Configuration");
            System.out.println("3. View Configuration");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    simulate(config, ticketPool);
                    break;
                case 2:
                    updateConfiguration(config, input);
                    break;
                case 3:
                    config.displayConfig();
                    break;
                case 4:
                    running = false;
                    Logger.log("Application exited.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    Logger.log("Invalid menu option selected.");
                    break;
            }
        }

        input.close();
    }

    public static void updateConfiguration(Configuration config, Scanner input) {
        System.out.println("\nUpdate Configuration:");
        config.configPrompt();
        config.saveConfig();
        System.out.println("\nConfiguration successfully updated.");
        Logger.log("Configuration successfully updated.");
    }

    public static void simulate(Configuration config, TicketPool ticketPool) {

        // To reset the ticket pool
        ticketPool.clearTickets();
        ticketPool.addTickets(config.getTotalTickets());

        System.out.println("Starting simulation...");
        Logger.log("Starting simulation...");

        // Create Vendor and Customer objects
        Vendor vendor1 = new Vendor(ticketPool, config.getTicketReleaseRate());
        Vendor vendor2 = new Vendor(ticketPool, config.getTicketReleaseRate());
        Customer customer1 = new Customer(ticketPool, config.getCustomerRetrievalRate());
        Customer customer2 = new Customer(ticketPool, config.getCustomerRetrievalRate());

        // Create threads and pass the Vendor/Customer objects to them
        Thread vendorThread1 = new Thread(vendor1);
        Thread vendorThread2 = new Thread(vendor2);
        Thread customerThread1 = new Thread(customer1);
        Thread customerThread2 = new Thread(customer2);

        // Start threads
        vendorThread1.start();
        customerThread1.start();
        vendorThread2.start();
        customerThread2.start();

        System.out.println("Simulation started. Press Enter to stop...");
        Logger.log("Simulation started successfully.");

        // Waiting for user to press Enter
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
            Logger.log("Error during simulation: " + e.getMessage());
        }

        // Stop all threads
        vendor1.stop();
        vendor2.stop();
        customer1.stop();
        customer2.stop();

        // waiting for threads to finish
        try {
            vendorThread1.join();
            vendorThread2.join();
            customerThread1.join();
            customerThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Logger.log("Error while stopping simulation: " + e.getMessage());
        }

        System.out.println("Simulation successfully stopped.");
        Logger.log("Simulation successfully stopped.");
    }
}
