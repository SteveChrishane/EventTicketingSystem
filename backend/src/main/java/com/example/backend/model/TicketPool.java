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
                System.out.println("Ticket added: " + ticket);
            } else {
                System.out.println("Can not add tickets to the pool. Max capacity reached.");
            }
        } finally {
            lock.unlock();
        }
    }


}
