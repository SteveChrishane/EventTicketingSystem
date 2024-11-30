package com.company;

public class Vendor implements Runnable {
    private TicketPool ticketPool;
    private int releaseRate;

    public Vendor(TicketPool ticketPool, int releaseRate) {
        this.ticketPool = ticketPool;
        this.releaseRate = releaseRate;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(releaseRate);
            ticketPool.addTickets(5);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
