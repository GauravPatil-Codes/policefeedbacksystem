package com.system.policefeedback.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.policefeedback.services.FeedbackServiceImpl;
import com.system.policefeedback.services.PoliceStationServiceImpl;

@RestController
@RequestMapping("/feedback")
public class AggregatedRatingController {

    @Autowired
    private FeedbackServiceImpl feedbackService;
    
    @Autowired
    private PoliceStationServiceImpl policeStationService;

    // 1️⃣ Get Aggregated Rating for a Police Station
    @GetMapping("/aggregated-rating/by-police-station/{policeStationId}")
    public ResponseEntity<Map<String, Double>> getAggregatedRatingByPoliceStation(
            @PathVariable String policeStationId) {

        double responseTimeRating = policeStationService.getPoliceStationResponseTimeRating(policeStationId);
        double userSatisfiedRating = feedbackService.getUserSatisfiedRatingByPoliceStation(policeStationId);
        double citizenFeedbackRating = feedbackService.getAverageRatingByPoliceStation(policeStationId);

        double aggregatedRating = calculateAggregatedRating(responseTimeRating, userSatisfiedRating, citizenFeedbackRating);

        Map<String, Double> response = new HashMap<>();
        response.put("aggregatedPoliceStationRating", aggregatedRating);

        return ResponseEntity.ok(response);
    }

    // 2️⃣ Get Aggregated Rating for a Subdivision
    @GetMapping("/aggregated-rating/by-subdivision/{subdivisionId}")
    public ResponseEntity<Map<String, Double>> getAggregatedRatingBySubdivision(
            @PathVariable String subdivisionId) {

        double responseTimeRating = policeStationService.getSubdivisionResponseTimeRating(subdivisionId);
        double userSatisfiedRating = feedbackService.getUserSatisfiedRatingBySubdivision(subdivisionId);
        double citizenFeedbackRating = feedbackService.getAverageRatingBySubdivision(subdivisionId);

        double aggregatedRating = calculateAggregatedRating(responseTimeRating, userSatisfiedRating, citizenFeedbackRating);

        Map<String, Double> response = new HashMap<>();
        response.put("aggregatedSubdivisionRating", aggregatedRating);

        return ResponseEntity.ok(response);
    }

    // 3️⃣ Get Aggregated Rating for a Head Office
    @GetMapping("/aggregated-rating/by-head-office/{headOfficeId}")
    public ResponseEntity<Map<String, Double>> getAggregatedRatingByHeadOffice(
            @PathVariable String headOfficeId) {

        double responseTimeRating = policeStationService.getHeadOfficeResponseTimeRating(headOfficeId);
        double userSatisfiedRating = feedbackService.getUserSatisfiedRatingByHeadOffice(headOfficeId);
        double citizenFeedbackRating = feedbackService.getAverageRatingByHeadoffice(headOfficeId);

        double aggregatedRating = calculateAggregatedRating(responseTimeRating, userSatisfiedRating, citizenFeedbackRating);

        Map<String, Double> response = new HashMap<>();
        response.put("aggregatedHeadOfficeRating", aggregatedRating);

        return ResponseEntity.ok(response);
    }

    // Helper method to calculate aggregated rating
    private double calculateAggregatedRating(double responseTimeRating, double userSatisfiedRating, double citizenFeedbackRating) {
        return (responseTimeRating + userSatisfiedRating + citizenFeedbackRating) / 3;
    }
}
