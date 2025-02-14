package com.system.policefeedback.repositories;

import com.system.policefeedback.entities.PoliceStations;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PoliceStationRepository extends MongoRepository<PoliceStations, String> {
    List<PoliceStations> findBySubdivisionId(String subdivisionId);
    List<PoliceStations> findByHeadOfficeId(String headOfficeId);
}

