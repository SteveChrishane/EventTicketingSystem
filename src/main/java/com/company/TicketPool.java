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
                System.out.println(count + " tickets added. Total available: " + availableTickets);
            } else {
                System.out.println("Cannot add tickets. Exceeds maximum capacity of " + maxTicketCapacity);
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
                System.out.println(count + " tickets purchased. Total available: " + availableTickets);
            } else {
                System.out.println("Not enough tickets available for purchase.");
            }
        } finally {
            lock.unlock();
        }
    }

    public void clearTickets() {
        availableTickets = 0;
    }
}
