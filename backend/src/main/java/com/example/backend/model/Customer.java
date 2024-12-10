package com.example.backend.model;

public class Customer implements Runnable {
    private int customerId;
    private TicketPool ticketPool;
    private int retrievalRate;
    private volatile boolean simRunning = true;

    public Customer(TicketPool ticketPool, int customerId, int retrievalRate) {
        this.ticketPool = ticketPool;
        this.customerId = customerId;
        this.retrievalRate = retrievalRate;
    }

    public void run() {

        while (simRunning) {
            for (int i = 0; i < retrievalRate; i++) {
                String ticket = ticketPool.removeTickets();
                if (ticket != null) {
                    System.out.println("Customer " + customerId + " purchased: " + ticket);
                } else {
                    System.out.println("Customer " + customerId + " found no tickets available.");
                }
            }
        }
    }

    public void stop() {
        simRunning = false;
    }
}
