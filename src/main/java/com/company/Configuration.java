package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Configuration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;
    private static final String configFileName = "config.json"; // Changed to JSON file

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void configPrompt() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the maximum ticket capacity of the system: ");
        maxTicketCapacity = inputValidation(input);

        do {
            System.out.print("Enter the total number of tickets available in the system: ");
            totalTickets = inputValidation(input);

            if (totalTickets > maxTicketCapacity) {
                System.out.println("Total tickets cannot exceed the maximum ticket capacity. Please try again.");
            }
        } while (totalTickets > maxTicketCapacity);

        System.out.print("Enter the ticket release rate: ");
        ticketReleaseRate = inputValidation(input);

        System.out.print("Enter the customer retrieval rate: ");
        customerRetrievalRate = inputValidation(input);

        System.out.println();
        System.out.println("System configured successfully!");
    }

    private int inputValidation(Scanner scanner) {
        int input = 0;
        boolean valid = false;
        while (!valid) {
            try {
                input = scanner.nextInt();
                if (input > 0) {
                    valid = true;
                } else {
                    System.out.println("Input must be a positive integer. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
            }
        }
        return input;
    }

    public void displayConfig() {
        System.out.println();
        System.out.println("Total Tickets: " + totalTickets);
        System.out.println("Ticket Release Rate: " + ticketReleaseRate);
        System.out.println("Customer Retrieval Rate: " + customerRetrievalRate);
        System.out.println("Max Ticket Capacity: " + maxTicketCapacity);
        System.out.println();
    }

    public void saveConfig() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(configFileName)) {
            gson.toJson(this, writer); // Serialize this Configuration object to JSON
            System.out.println("Configuration saved successfully to " + configFileName);
        } catch (IOException e) {
            System.err.println("Error saving configuration: " + e.getMessage());
        }
    }

    public boolean loadConfig() {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(configFileName)) {
            Configuration config = gson.fromJson(reader, Configuration.class); // Deserialize JSON to Configuration
                                                                               // object
            if (config != null) {
                this.totalTickets = config.totalTickets;
                this.ticketReleaseRate = config.ticketReleaseRate;
                this.customerRetrievalRate = config.customerRetrievalRate;
                this.maxTicketCapacity = config.maxTicketCapacity;

                return true; // Successfully loaded configuration
            }
        } catch (IOException e) {
            System.err.println("Error loading configuration: " + e.getMessage());
            return false; // Failed to load configuration
        }

        return false; // No valid configuration found
    }

    public boolean hasValidValues() {
        if (totalTickets > 0 && ticketReleaseRate > 0 && customerRetrievalRate > 0 && maxTicketCapacity > 0) {
            return true;
        } else {
            System.out.println("Invalid configuration values. Please reconfigure.");
            return false;
        }
    }

}