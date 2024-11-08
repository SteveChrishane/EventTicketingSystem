package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String userRole;
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.print("configure / vendor / customer / exit: ");
            userRole = input.nextLine().trim().toLowerCase();

            switch (userRole) {
                case "configure":
                    System.out.println("Hello Configure!");
                    Configuration config = new Configuration();
                    config.configPrompt();
                    config.displayConfig();
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
            
                default:
                    System.out.println("Unknown command.");
                    break;
            }
            
        }

        
    

        // Configuration config = new Configuration();
        // config.configPrompt();
        // config.displayConfig();

        // boolean running = true;   
   
        // while (running) {
        //     System.out.println("Commands: start, stop, status, exit");
        //     String command = input.next();
            
        //     switch (command.toLowerCase()) {
        //         case "start":
        //             startTicketHandling();
        //             break;
        //         case "stop":
        //             stopTicketHandling();
        //             break;
        //         case "status":
        //             displayStatus();
        //             break;
        //         case "exit":
        //             running = false;
        //             break;
        //         default:
        //             System.out.println("Unknown command.");

        //     }
        // }





        input.close();

    }        
    

    // private static void startTicketHandling() {
    //     // Logic to start the producer-consumer threads
    // }
    
    // private static void stopTicketHandling() {
    //     // Logic to stop the threads gracefully
    // }

    // private static void displayStatus() {
    //     // Logic to show current tickets available, tickets sold, etc.
    // }


}

