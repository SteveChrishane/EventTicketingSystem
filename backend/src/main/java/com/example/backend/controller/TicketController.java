package com.example.backend.controller;

import com.example.backend.config.Config;
import com.example.backend.service.TicketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticketing")
@CrossOrigin(origins = "http://localhost:5173")
public class TicketController {

    @Autowired
    private TicketingService ticketingService;

    @Autowired
    private Config config;

    @PostMapping("/start")
    public String startSimulation() {
        try {
            ticketingService.startSimulation();
            return "Simulation started.";
        } catch (IllegalStateException e) {
            return "Simulation is already running.";
        }
    }

    @PostMapping("/stop")
    public String stopSimulation() {
        try {
            ticketingService.stopSimulation();
            return "Simulation stopped.";
        } catch (IllegalStateException e) {
            return "Simulation is not running.";
        }
    }

    @PostMapping("/config")
    public String updateConfig(@RequestBody Config newConfig) {
        config.setTotalTickets(newConfig.getTotalTickets());
        config.setTicketReleaseRate(newConfig.getTicketReleaseRate());
        config.setCustomerRetrievalRate(newConfig.getCustomerRetrievalRate());
        config.setMaxTicketCapacity(newConfig.getMaxTicketCapacity());
        return "Configuration updated.";
    }

    @GetMapping("/status")
    public String getStatus() {
        return "Available tickets: " + ticketingService.getAvailableTickets();
    }

}
