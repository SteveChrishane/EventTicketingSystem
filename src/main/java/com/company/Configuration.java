package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Configuration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    public void configPrompt() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the total number of tickets available in the system: ");
        totalTickets = inputValidation(input);
        System.out.print("Enter the ticket release rate: ");
        ticketReleaseRate = inputValidation(input);
        System.out.print("Enter the customer retrieval rate: ");
        customerRetrievalRate = inputValidation(input);
        System.out.print("Enter maximum ticket capacity of the system: ");
        maxTicketCapacity = inputValidation(input);

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
        System.out.println("System configured successfully!");
        System.out.println();
        System.out.println("Total Tickets: " + totalTickets);
        System.out.println("Ticket Release Rate: " + ticketReleaseRate);
        System.out.println("Customer Retrieval Rate: " + customerRetrievalRate);
        System.out.println("Max Ticket Capacity: " + maxTicketCapacity);
        System.out.println();
    }


}