package com.example.backend.model;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

public class TicketPool {
    private final ConcurrentLinkedQueue<String> tickets = new ConcurrentLinkedQueue<>();
    private final ReentrantLock lock = new ReentrantLock();
    private int maxCapacity;

    public TicketPool(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void addTickets(String ticket) {
        lock.lock();
        try {
            if (tickets.size() < maxCapacity) {
                tickets.offer(ticket);
                // System.out.println("Ticket added: " + ticket);
            } else {
                System.out.println("Cannot add tickets to the pool. Max capacity reached.");
            }
        } finally {
            lock.unlock();
        }
    }

    public String removeTickets() {
        lock.lock();
        try {
            return tickets.poll();
        } finally {
            lock.unlock();
        }
    }

    public int getTicketCount() {
        lock.lock();
        try {
            return tickets.size();
        } finally {
            lock.unlock();
        }
    }

    public void clearTickets() {
        tickets.clear();
    }

}
