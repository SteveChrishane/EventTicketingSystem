package com.example.backend.config;

import org.springframework.stereotype.Component;

@Component
public class Config {
    private int totalTickets = 56;
    private int ticketReleaseRate = 3;
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

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }

}
