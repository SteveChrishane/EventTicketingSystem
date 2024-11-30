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
                Thread.sleep(releaseRate);
                ticketPool.addTickets(5);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        simRunning = false;
    }
}