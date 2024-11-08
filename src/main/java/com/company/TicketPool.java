package com.company;

public class TicketPool {
        
    private int availableTickets;

    public void addTickets(int count) {
        availableTickets += count;
        System.out.println(count + " tickets added.");
        System.out.println("Total available tickets: " + availableTickets);

    }

    public void removeTickets(int count){
        if (availableTickets > 0) {
            availableTickets -= count;
            System.out.println("Tickets removed.");
            System.out.println("Total available tickets: " + availableTickets);
        } else {
            System.out.println("No tickets available to remove.");
        }
    }
}
