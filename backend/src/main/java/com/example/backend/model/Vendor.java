package com.example.backend.model;

public class Vendor implements Runnable {
    private int vendorId;
    private TicketPool ticketPool;
    private int releaseRate;

    public Vendor(int vendorId, TicketPool ticketPool, int releaseRate) {
        this.vendorId = vendorId;
        this.ticketPool = ticketPool;
        this.releaseRate = releaseRate;
    }
    
    @Override
    public void run() {

    }
}
