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
    
}
