package com.company;

import java.util.concurrent.locks.ReentrantLock;

public class TicketPool {

    private int availableTickets;
    private int maxTicketCapacity;
    private final ReentrantLock lock = new ReentrantLock();

    public TicketPool(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public void addTickets(int count) {
        lock.lock();
        try {
            if (availableTickets + count <= maxTicketCapacity) {
                availableTickets += count;
                String message = count + " tickets added. Total available: " + availableTickets;
                System.out.println(message);
                Logger.log(message);
            } else {
                String message = "Cannot add tickets. Exceeds maximum capacity of " + maxTicketCapacity;
                System.out.println(message);
                Logger.log(message);
            }
        } finally {
            lock.unlock();
        }
    }

    public void removeTickets(int count) {
        lock.lock();
        try {
            if (availableTickets >= count) {
                availableTickets -= count;
                String message = count + " tickets purchased. Total available: " + availableTickets;
                System.out.println(message);
                Logger.log(message);
            } else {
                String message = "Not enough tickets available for purchase.";
                System.out.println(message);
                Logger.log(message);
            }
        } finally {
            lock.unlock();
        }
    }

    public void clearTickets() {
        availableTickets = 0;
        Logger.log("All tickets cleared.");
    }
}
