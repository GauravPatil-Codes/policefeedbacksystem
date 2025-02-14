package com.system.policefeedback.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
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
    @GetMapping("/getfeedback")
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
    
    
    // New API to get feedback by police station ID
    @GetMapping("/feedback/by-policestation/{policeStationId}")
    public ResponseEntity<List<Feedback>> getFeedbackByPoliceStationId(@PathVariable String policeStationId) {
        List<Feedback> feedbackList = feedbackService.getFeedbackByPoliceStationId(policeStationId);
        if (feedbackList.isEmpty()) {
            return ResponseEntity.noContent().build(); // No feedback found
        }
        return ResponseEntity.ok(feedbackList);
    }
    
 // 1. Get feedback by week
    @GetMapping("/feedback/by-week")
    public ResponseEntity<List<Feedback>> getFeedbackByWeek() {
        List<Feedback> feedbackList = feedbackService.getFeedbackByWeek();
        return ResponseEntity.ok(feedbackList);
    }

    // 2. Get feedback by month
    @GetMapping("/feedback/by-month")
    public ResponseEntity<List<Feedback>> getFeedbackByMonth() {
        List<Feedback> feedbackList = feedbackService.getFeedbackByMonth();
        return ResponseEntity.ok(feedbackList);
    }

    // 3. Get feedback by a particular date
    @GetMapping("/feedback/by-date")
    public ResponseEntity<List<Feedback>> getFeedbackByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Feedback> feedbackList = feedbackService.getFeedbackByDate(date);
        return ResponseEntity.ok(feedbackList);
    }

    // 4. Get feedback by rating
    @GetMapping("/feedback/by-rating/{rating}")
    public ResponseEntity<List<Feedback>> getFeedbackByRating(@PathVariable double rating) {
        List<Feedback> feedbackList = feedbackService.getFeedbackByRating(rating);
        return ResponseEntity.ok(feedbackList);
    }

    // 5. Get feedback by police station name
    @GetMapping("/feedback/by-police-station-name")
    public ResponseEntity<List<Feedback>> getFeedbackByPoliceStationName(
            @RequestParam String policeStationName) {
        List<Feedback> feedbackList = feedbackService.getFeedbackByPoliceStationName(policeStationName);
        return ResponseEntity.ok(feedbackList);
    }

    // 6. Get feedback by username
    @GetMapping("/feedback/by-username/{username}")
    public ResponseEntity<List<Feedback>> getFeedbackByUsername(@PathVariable String username) {
        List<Feedback> feedbackList = feedbackService.getFeedbackByUsername(username);
        return ResponseEntity.ok(feedbackList);
    }

    // 7. Search feedback by any keyword
    @GetMapping("/feedback/search")
    public ResponseEntity<List<Feedback>> searchFeedbackByKeyword(@RequestParam String keyword) {
        List<Feedback> feedbackList = feedbackService.searchFeedbackByKeyword(keyword);
        return ResponseEntity.ok(feedbackList);
        
        
        
    }
    
    //feedback by headofficeid
    
    @GetMapping("/feedback/by-headoffice/{headofficeId}")
    public ResponseEntity<List<Feedback>> getFeedbackByHeadoffice(@PathVariable String headofficeId) {
        List<Feedback> feedbackList = feedbackService.getFeedbackByHeadoffice(headofficeId);
        return ResponseEntity.ok(feedbackList);
    }
    
    //feedback by subdivisionid
    @GetMapping("/feedback/by-subdivision/{subdivisionId}")
    public ResponseEntity<List<Feedback>> getFeedbackBySubdivision(@PathVariable String subdivisionId) {
        List<Feedback> feedbackList = feedbackService.getFeedbackBySubdivision(subdivisionId);
        return ResponseEntity.ok(feedbackList);
    }

    //getaverage rating headoffice
    @GetMapping("/rating/by-headoffice/{headofficeId}")
    public ResponseEntity<Double> getAverageRatingByHeadoffice(@PathVariable String headofficeId) {
        double avgRating = feedbackService.getAverageRatingByHeadoffice(headofficeId);
        return ResponseEntity.ok(avgRating);
    }

    //getaverage rating by subdivisionid
    @GetMapping("/rating/by-subdivision/{subdivisionId}")
    public ResponseEntity<Double> getAverageRatingBySubdivision(@PathVariable String subdivisionId) {
        double avgRating = feedbackService.getAverageRatingBySubdivision(subdivisionId);
        return ResponseEntity.ok(avgRating);
    }

    
    //getaverage rating by policestationid
    @GetMapping("/rating/by-policestation/{policeStationId}")
    public ResponseEntity<Double> getAverageRatingByPoliceStation(@PathVariable String policeStationId) {
        double avgRating = feedbackService.getAverageRatingByPoliceStation(policeStationId);
        return ResponseEntity.ok(avgRating);
    }

    

}
