package com.company;

public class TicketPool {
        
    private int availableTickets;

    public void addTickets(int count) {
        availableTickets += count;
        System.out.println(count + " tickets added.");
        System.out.println("Total available tickets: " + availableTickets);

    }

    public void removeTickets(){
        if (availableTickets > 0) {
            availableTickets--;
            System.out.println("Ticket purchased.");
            System.out.println("Total available tickets: " + availableTickets);
        } else {
            System.out.println("No ticket purchased.");
        }
    }
}
