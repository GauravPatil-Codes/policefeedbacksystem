package com.system.policefeedback.controllers;

import com.system.policefeedback.entities.PoliceStations;
import com.system.policefeedback.services.PoliceStationServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class PoliceStationsController {

    @Autowired
    private PoliceStationServiceImpl policeStationService;

    // GET API to fetch police station by ID
    @GetMapping("/{policeStationId}")
    public PoliceStations getPoliceStationDetails(@PathVariable String policeStationId) {
        return policeStationService.getPoliceStationById(policeStationId);
    }
}
