package com.example.backend.model;

public class Vendor implements Runnable {
    private int vendorId;
    private TicketPool ticketPool;
    private int releaseRate;
    private volatile boolean simRunning = true;

    public Vendor(int vendorId, TicketPool ticketPool, int releaseRate) {
        this.vendorId = vendorId;
        this.ticketPool = ticketPool;
        this.releaseRate = releaseRate;
    }

    @Override
    public void run() {

        while (simRunning) {
            for (int i = 0; i < releaseRate; i++) {
                String ticket = "Vendor - " + vendorId + " - Ticket - " + System.currentTimeMillis();
                ticketPool.addTickets(ticket);
            }
        }
    }

    public void stop() {
        simRunning = false;
    }
}
