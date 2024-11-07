package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configPrompt();
        config.displayConfig();

        boolean running = true;   
        Scanner input = new Scanner(System.in);
        
        while (running) {
            System.out.println("Commands: start, stop, status, exit");
            String command = input.next();
            
            switch (command.toLowerCase()) {
                case "start":
                    startTicketHandling();
                    break;
                case "stop":
                    stopTicketHandling();
                    break;
                case "status":
                    displayStatus();
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Unknown command.");

            }
        }

        input.close();

    }        
    

    private static void startTicketHandling() {
        // Logic to start the producer-consumer threads
    }
    
    private static void stopTicketHandling() {
        // Logic to stop the threads gracefully
    }

    private static void displayStatus() {
        // Logic to show current tickets available, tickets sold, etc.
    }
}