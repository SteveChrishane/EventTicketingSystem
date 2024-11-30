package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String userRole;
        Scanner input = new Scanner(System.in);

        Configuration config = new Configuration();

        if (!config.loadConfig() || !config.hasValidValues()) {
            // If loading failed or values are invalid, prompt for configuration
            config.configPrompt();
            config.saveConfig(); // Save new configuration after prompting
        } else {
            System.out.println("Configuration loaded successfully.");
        }

        config.displayConfig(); // Display current settings

        boolean running = true;
        while (running) {

            System.out.print("simulate / vendor / customer / exit: ");
            userRole = input.nextLine().trim().toLowerCase();

            switch (userRole) {
                case "simulate":
                    System.out.println("simulation starting...");
                    simulate();
                    break;

                case "vendor":
                    System.out.println("Hello Vendor!");

                    break;

                case "customer":
                    System.out.println("Hello Customer!");
                    break;

                case "exit":
                    running = false;
                    break;

                case "q":
                    running = false;
                    break;

                default:
                    System.out.println("Unknown command.");
                    break;
            }

        }

        input.close();

    }

    public static void simulate() {
        TicketPool ticketPool = new TicketPool();

        Thread vendor1 = new Thread(new Vendor(ticketPool, 1000));
        Thread vendor2 = new Thread(new Vendor(ticketPool, 1500));

        Thread customer1 = new Thread(new Customer(ticketPool, 500));
        Thread customer2 = new Thread(new Customer(ticketPool, 700));

        vendor1.start();
        customer1.start();
        vendor2.start();
        customer2.start();

    }

}
