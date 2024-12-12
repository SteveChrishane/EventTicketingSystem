package com.company;

public class Vendor implements Runnable {
    private TicketPool ticketPool;
    private int releaseRate;
    private volatile boolean simRunning = true;

    public Vendor(TicketPool ticketPool, int releaseRate) {
        this.ticketPool = ticketPool;
        this.releaseRate = releaseRate;
    }

    @Override
    public void run() {
        try {
            while (simRunning) {
                Thread.sleep(1000); // Sleep for the release rate duration
                ticketPool.addTickets(releaseRate);
                Logger.log("Vendor released " + releaseRate + " tickets.");
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