package com.example.backend.service;

import com.example.backend.config.Config;
import com.example.backend.model.Customer;
import com.example.backend.model.TicketPool;
import com.example.backend.model.Vendor;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketingService {
    private TicketPool ticketPool;
    private Config config;
    private List<Thread> vendorThreads = new ArrayList<>();
    private List<Thread> customerThreads = new ArrayList<>();
    private List<Vendor> vendors = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private boolean isSimulationRunning = false;

    public TicketingService(Config config) {
        this.config = config;
        this.ticketPool = new TicketPool(config.getMaxTicketCapacity());
    }

    // To start the simulation
    public synchronized void startSimulation() {
        if (isSimulationRunning) {
            throw new IllegalStateException("Simulation already running");
        }

        // Reset the ticket pool
        ticketPool.clearTickets();

        // Add tickets to the pool
        for (int i = 0; i < config.getTotalTickets(); i++) {
            ticketPool.addTickets(String.valueOf(System.nanoTime()));
        }

        System.out.println("\nTicket pool initialized with " + ticketPool.getTicketCount() + " tickets.");
        System.out.println("\nStarting simulation...\n");

        // Create 2 vendors
        for (int i = 0; i < 2; i++) {
            Vendor vendor = new Vendor(i + 1, ticketPool, config.getTicketReleaseRate());
            vendors.add(vendor);
            Thread vendorThread = new Thread(vendor);
            vendorThreads.add(vendorThread);
            vendorThread.start();
        }

        // Create 2 customers
        for (int i = 0; i < 2; i++) {
            Customer customer = new Customer(ticketPool, i + 1, config.getCustomerRetrievalRate());
            customers.add(customer);
            Thread customerThread = new Thread(customer);
            customerThreads.add(customerThread);
            customerThread.start();
        }

        isSimulationRunning = true;

    }

    // To stop the simulation
    public synchronized void stopSimulation() {
        if (!isSimulationRunning) {
            throw new IllegalStateException("Simulation already stopped");
        }

        // Stop all the threads
        for (Vendor vendor : vendors) {
            vendor.stop();
        }

        for (Customer customer : customers) {
            customer.stop();
        }

        // Waiting for threads to finish
        for (Thread thread : vendorThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Thread thread : customerThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Clear thread lists and objects
        vendors.clear();
        customers.clear();
        vendorThreads.clear();
        customerThreads.clear();

        isSimulationRunning = false;
        System.out.println("\nSimulation successfully stopped.");
        System.out.println("\nAvailable tickets: " + ticketPool.getTicketCount());
    }

    public int getAvailableTickets() {
        return ticketPool.getTicketCount();
    }

    // @PreDestroy
    // public void cleanup() {
    // if (isSimulationRunning) {
    // stopSimulation();
    // }
    // }

}
