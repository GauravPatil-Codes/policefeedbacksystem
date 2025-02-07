package com.system.policefeedback.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.system.policefeedback.entities.Feedback;

public interface FeedbackRepository extends MongoRepository<Feedback, String> {

	List<Feedback> findByPoliceStationId(String policeStationId);

	// Custom query methods
    List<Feedback> findByTimestampBetween(LocalDateTime start, LocalDateTime end);

    List<Feedback> findByUserfeedbackRating(double rating);

    List<Feedback> findByPolicestationnameContainingIgnoreCase(String policeStationName);

    List<Feedback> findByUserNameContainingIgnoreCase(String username);

    // Full-text search using regex for any attribute containing the keyword
    @Query("{ $or: [ { 'userName': { $regex: ?0, $options: 'i' } }, { 'UserfeedbackComments': { $regex: ?0, $options: 'i' } }, { 'Policestationname': { $regex: ?0, $options: 'i' } }, { 'PolicestationAddress': { $regex: ?0, $options: 'i' } } ] }")
    List<Feedback> searchFeedbackByKeyword(String keyword);
}
