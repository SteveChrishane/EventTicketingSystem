package com.example.backend.config;

import org.springframework.stereotype.Component;

@Component
public class Config {
    private int totalTickets = 100;
    private int ticketReleaseRate = 5;
    private int customerRetrievalRate = 2;
    private int maxTicketCapacity = 200;

    public int getTotalTickets() {
        return totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }
}
