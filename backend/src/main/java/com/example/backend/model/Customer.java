package com.example.backend.model;

public class Customer implements Runnable {
    private int customerId;
    private TicketPool ticketPool;
    private  int retrievalRate;

    public Customer(TicketPool ticketPool, int customerId, int retrievalRate) {
        this.ticketPool = ticketPool;
        this.customerId = customerId;
        this.retrievalRate = retrievalRate;
    }
    public void run() {

    }
}
