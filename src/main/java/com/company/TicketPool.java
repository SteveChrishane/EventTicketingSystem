package com.company;

import java.util.concurrent.locks.ReentrantLock;

public class TicketPool {

    private int availableTickets;
    private final ReentrantLock lock = new ReentrantLock();

    public void addTickets(int count) {
        lock.lock();
        try {
            availableTickets += count;
            System.out.println(count + " tickets added. Total available: " + availableTickets);
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
                System.out.println("No tickets available.");
            }
        } finally {
            lock.unlock();
        }
    }
}
