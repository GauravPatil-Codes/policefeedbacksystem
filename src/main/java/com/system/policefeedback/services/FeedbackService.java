package com.system.policefeedback.services;

import com.system.policefeedback.entities.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FeedbackService {

    Feedback saveFeedback(Feedback feedback);

    Page<Feedback> getAllFeedback(Pageable pageable);

    Optional<Feedback> getFeedbackById(String id);

    Optional<Feedback> updateFeedback(String id, Feedback updatedFeedback);

    boolean deleteFeedback(String id);
    List<Feedback> getFeedbackByWeek();
    List<Feedback> getFeedbackByMonth();
    List<Feedback> getFeedbackByDate(LocalDate date);
    List<Feedback> getFeedbackByRating(double rating);
    List<Feedback> getFeedbackByPoliceStationName(String policeStationName);
    List<Feedback> getFeedbackByUsername(String username);
    List<Feedback> searchFeedbackByKeyword(String keyword);
    List<Feedback> getFeedbackByHeadoffice(String headofficeId);

	List<Feedback> getFeedbackBySubdivision(String subdivisionId);

	double getAverageRatingByHeadoffice(String headofficeId);

	double getAverageRatingBySubdivision(String subdivisionId);

	double getAverageRatingByPoliceStation(String policeStationId);

	List<Feedback> getFeedbackByDepartment(String department);
}
