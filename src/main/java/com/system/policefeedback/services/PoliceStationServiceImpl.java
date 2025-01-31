package com.system.policefeedback.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.policefeedback.entities.PoliceStations;
import com.system.policefeedback.repositories.PoliceStationRepository;

@Service
public class PoliceStationServiceImpl implements PoliceStationService {


	    @Autowired
	    private PoliceStationRepository policeStationRepository;

	    public PoliceStations getPoliceStationById(String policeStationId) {
	        return policeStationRepository.findById(policeStationId)
	                .orElseThrow(() -> new RuntimeException("Police Station not found with ID: " + policeStationId));
	    }
	}



