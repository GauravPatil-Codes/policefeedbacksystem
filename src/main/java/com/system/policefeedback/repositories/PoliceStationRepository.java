package com.system.policefeedback.repositories;

import com.system.policefeedback.entities.PoliceStations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliceStationRepository extends MongoRepository<PoliceStations, String> {
}
