package com.system.policefeedback.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.system.policefeedback.entities.Feedback;
import com.system.policefeedback.services.FeedbackService;
import com.system.policefeedback.services.FeedbackServiceImpl;

@RestController
@RequestMapping("/api")
public class FeedbackController {

    private final FeedbackServiceImpl feedbackService;

    @Autowired
    public FeedbackController(FeedbackServiceImpl feedbackService) {
        this.feedbackService = feedbackService;
    }

    // POST API to submit feedback
    @PostMapping("/feedback")
    public ResponseEntity<Feedback> submitFeedback(@RequestBody Feedback feedback) {
        feedback.setTimestamp(LocalDateTime.now());
        Feedback savedFeedback = feedbackService.saveFeedback(feedback);
        return ResponseEntity.ok(savedFeedback);
    }

    // GET API to fetch all feedbacks with pagination
    @GetMapping("/feedback")
    public ResponseEntity<Page<Feedback>> getAllFeedback(Pageable pageable) {
        Page<Feedback> feedbacks = feedbackService.getAllFeedback(pageable);
        return ResponseEntity.ok(feedbacks);
    }

    // GET API to fetch feedback by ID
    @GetMapping("/feedback/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable String id) {
        return feedbackService.getFeedbackById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT API to update feedback by ID
    @PutMapping("/feedback/{id}")
    public ResponseEntity<Feedback> updateFeedback(
            @PathVariable String id, @RequestBody Feedback updatedFeedback) {
        return feedbackService.updateFeedback(id, updatedFeedback)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE API to delete feedback by ID
    @DeleteMapping("/feedback/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable String id) {
        if (feedbackService.deleteFeedback(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
