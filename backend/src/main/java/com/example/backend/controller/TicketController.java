package com.example.backend.controller;

import com.example.backend.service.TicketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticketing")
public class TicketController {

    @Autowired
    private TicketingService ticketingService;

    @PostMapping("/start")
    public  String startSimulation(){
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

    @GetMapping("/status")
    public String getStatus() {
        return "Available tickets: " + ticketingService.getAvailableTickets();
    }


}
