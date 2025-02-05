package com.system.policefeedback.services;

import com.system.policefeedback.entities.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface FeedbackService {

    Feedback saveFeedback(Feedback feedback);

    Page<Feedback> getAllFeedback(Pageable pageable);

    Optional<Feedback> getFeedbackById(String id);

    Optional<Feedback> updateFeedback(String id, Feedback updatedFeedback);

    boolean deleteFeedback(String id);
}
