package com.company;

public class Customer implements Runnable {
    private TicketPool ticketPool;
    private int retrievalRate;
    private volatile boolean simRunning = true;

    public Customer(TicketPool pool, int rate) {
        this.ticketPool = pool;
        this.retrievalRate = rate;
    }

    @Override
    public void run() {
        try {
            while (simRunning) {
                Thread.sleep(retrievalRate);
                ticketPool.removeTickets(1); // Attempt to purchase a ticket
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        simRunning = false; // Set stop flag
    }
}