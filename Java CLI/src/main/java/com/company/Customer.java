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
                Thread.sleep(1000); // Sleep for the retrieval rate duration
                ticketPool.removeTickets(retrievalRate);
                Logger.log("Customer purchased " + retrievalRate + " tickets.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // using a flag to stop the simulation
    public void stop() {
        simRunning = false;
    }
}