package com.system.policefeedback.services;

import com.system.policefeedback.entities.PoliceStations;
import com.system.policefeedback.repositories.PoliceStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoliceStationServiceImpl implements PoliceStationService {

    @Autowired
    private PoliceStationRepository policeStationRepository;

    // Fetch police station by ID
    public Optional<PoliceStations> getPoliceStationById(String policeStationId) {
        return policeStationRepository.findById(policeStationId);
    }

    // Create a new police station
    public PoliceStations createPoliceStation(PoliceStations policeStation) {
        return policeStationRepository.save(policeStation);
    }

    // Update existing police station by ID
    public Optional<PoliceStations> updatePoliceStation(String policeStationId, PoliceStations updatedStation) {
        return policeStationRepository.findById(policeStationId).map(existingStation -> {
            existingStation.setPolicestationname(updatedStation.getPolicestationname());
            existingStation.setPolicestationQRlink(updatedStation.getPolicestationQRlink());
            existingStation.setPolicestationRating(updatedStation.getPolicestationRating());
            existingStation.setPolicestationAddress(updatedStation.getPolicestationAddress());
            existingStation.setPolicestationlatitude(updatedStation.getPolicestationlatitude());
            existingStation.setPolicestationlogintude(updatedStation.getPolicestationlogintude());
            existingStation.setContactNumber(updatedStation.getContactNumber());
            return policeStationRepository.save(existingStation);
        });
    }

    public boolean deletePoliceStation(String policeStationId) {
        Optional<PoliceStations> policeStation = policeStationRepository.findById(policeStationId);
        if (policeStation.isPresent()) {
            policeStationRepository.deleteById(policeStationId);
            return true;
        }
        return false;
    }

	

	public List<PoliceStations> getAllPoliceStations() {
		// TODO Auto-generated method stub
		return policeStationRepository.findAll();
	}
	
	
}
