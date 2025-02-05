package com.system.policefeedback.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.system.policefeedback.entities.Feedback;

public interface FeedbackRepository extends MongoRepository<Feedback, String> {

}
