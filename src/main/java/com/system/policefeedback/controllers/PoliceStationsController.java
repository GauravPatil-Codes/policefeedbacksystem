package com.system.policefeedback.controllers;

import com.system.policefeedback.entities.PoliceStations;
import com.system.policefeedback.services.PoliceStationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dashboard")
public class PoliceStationsController {

    @Autowired
    private PoliceStationServiceImpl policeStationService;

    // GET API to fetch police station by ID
    @GetMapping("/{policeStationId}")
    public ResponseEntity<PoliceStations> getPoliceStationDetails(@PathVariable String policeStationId) {
        return policeStationService.getPoliceStationById(policeStationId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
 // GET API to fetch all police stations
    @GetMapping("/getpolicestation")
    public List<PoliceStations> getAllPoliceStationDetails() {
        return policeStationService.getAllPoliceStations();
    }

    // POST API to create a new police station
    @PostMapping("/policestation")
    public ResponseEntity<PoliceStations> createPoliceStation(@RequestBody PoliceStations policeStation) {
        PoliceStations createdStation = policeStationService.createPoliceStation(policeStation);
        return ResponseEntity.ok(createdStation);
    }

    // PUT API to update police station details by ID
    @PutMapping("/{policeStationId}")
    public ResponseEntity<PoliceStations> updatePoliceStation(
            @PathVariable String policeStationId,
            @RequestBody PoliceStations updatedPoliceStation) {
        return policeStationService.updatePoliceStation(policeStationId, updatedPoliceStation)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{policeStationId}")
    public ResponseEntity<Void> deletePoliceStation(@PathVariable String policeStationId) {
        if (policeStationId == null || policeStationId.trim().isEmpty()) {
            return ResponseEntity.badRequest().build(); // 400 Bad Request for invalid ID
        }
        
        try {
            if (policeStationService.deletePoliceStation(policeStationId)) {
                return ResponseEntity.noContent().build(); // 204 No Content for successful deletion
            }
            return ResponseEntity.notFound().build(); // 404 Not Found if the police station doesn't exist
        } catch (Exception e) {
            // Log the exception and return 500 Internal Server Error
            e.printStackTrace(); // Replace with logger in production
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    
    // Get By Id
}
