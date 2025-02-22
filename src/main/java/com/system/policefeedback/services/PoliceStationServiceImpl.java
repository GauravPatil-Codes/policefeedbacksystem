package com.system.policefeedback.services;

import com.system.policefeedback.entities.Feedback;
import com.system.policefeedback.entities.HeadOffice;
import com.system.policefeedback.entities.PoliceStations;
import com.system.policefeedback.entities.Subdivision;
import com.system.policefeedback.repositories.FeedbackRepository;
import com.system.policefeedback.repositories.PoliceStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PoliceStationServiceImpl implements PoliceStationService {

    @Autowired
    private PoliceStationRepository policeStationRepository;
    
    @Autowired
    private FeedbackRepository feedbackRepository;

    // Fetch police station by ID
    public Optional<PoliceStations> getPoliceStationById(String policeStationId) {
        return policeStationRepository.findById(policeStationId);
    }

    // Create a new police station
    public PoliceStations createPoliceStation(PoliceStations policeStation) {
        return policeStationRepository.save(policeStation);
    }

    // Update existing police station by ID
    public Optional<PoliceStations> updatePoliceStation(String policeStationId, PoliceStations updatedStation) {
        return policeStationRepository.findById(policeStationId).map(existingStation -> {
            existingStation.setPolicestationName(updatedStation.getPolicestationName());
            existingStation.setPolicestationQRLink(updatedStation.getPolicestationQRLink());
            existingStation.setPolicestationRating(updatedStation.getPolicestationRating());
            existingStation.setPolicestationAddress(updatedStation.getPolicestationAddress());
            existingStation.setPolicestationLatitude(updatedStation.getPolicestationLatitude());
            existingStation.setPolicestationLongitude(updatedStation.getPolicestationLongitude());
            existingStation.setContactNumber(updatedStation.getContactNumber());

            // Update Subdivision if provided
            if (updatedStation.getSubdivision() != null) {
                existingStation.setSubdivision(updatedStation.getSubdivision());
            }

            // Update Head Office if provided
            if (updatedStation.getHeadOffice() != null) {
                existingStation.setHeadOffice(updatedStation.getHeadOffice());
            }

            // Update feedback IDs if provided
            if (updatedStation.getFeedbackIds() != null) {
                existingStation.setFeedbackIds(updatedStation.getFeedbackIds());
            }

            return policeStationRepository.save(existingStation);
        });
    }

    public boolean deletePoliceStation(String policeStationId) {
        Optional<PoliceStations> policeStation = policeStationRepository.findById(policeStationId);
        if (policeStation.isPresent()) {
            policeStationRepository.deleteById(policeStationId);
            return true;
        }
        return false;
    }

	

	public List<PoliceStations> getAllPoliceStations() {
		// TODO Auto-generated method stub
		return policeStationRepository.findAll();
	}
	
	 //calculate policestatin rating as per  policestationresponsetime rating
	
	public void updatePoliceStationRating(String policeStationId) {
	    System.out.println("updatePoliceStationRating method started for Police Station ID: " + policeStationId);

	    // Fetch the police station
	    Optional<PoliceStations> policeStationOpt = policeStationRepository.findById(policeStationId);
	    if (!policeStationOpt.isPresent()) {
	        System.out.println("Police station not found for ID: " + policeStationId);
	        return;
	    }
	    
	    PoliceStations policeStation = policeStationOpt.get();
	    System.out.println("Police Station Found: " + policeStation.getPolicestationName());

	    // Fetch all feedback for this police station
	    List<Feedback> feedbackList = feedbackRepository.findByPoliceStationId(policeStationId);
	    System.out.println("Number of feedback records found: " + feedbackList.size());

	    if (feedbackList.isEmpty()) {
	        System.out.println("No feedback found. Setting rating to 0.");
	        policeStation.setPolicestationRating(0);
	    } else {
	        double totalRating = 0;
	        int feedbackCount = 0;

	        for (Feedback feedback : feedbackList) {
	            if (feedback.getTimestamp() != null && feedback.getSubdepartmenttimestamp() != null) {
	                Duration responseTime = Duration.between(feedback.getTimestamp(), feedback.getSubdepartmenttimestamp());
	                long responseHours = responseTime.toHours();
	                System.out.println("Feedback ID: " + feedback.getId() + " - Response time in hours: " + responseHours);

	                int rating = calculateResponseRating(responseHours);
	                System.out.println("Calculated rating: " + rating);

	                totalRating += rating;
	                feedbackCount++;
	            } else {
	                System.out.println("Skipping feedback ID: " + feedback.getId() + " due to null timestamps.");
	            }
	        }

	        double averageRating = feedbackCount > 0 ? totalRating / feedbackCount : 0;
	        System.out.println("Average Rating for Police Station calculated: " + averageRating);
	        policeStation.setPolicestationRating(averageRating);
	    }

	    // Save updated police station rating
	    policeStationRepository.save(policeStation);
	    System.out.println("Police station rating updated and saved successfully.");

	    // Update Subdivision Rating
	    updateSubdivisionRating(policeStation.getSubdivision());

	    // Update Head Office Rating
	    updateHeadOfficeRating(policeStation.getHeadOffice());
	}

	private void updateSubdivisionRating(Subdivision subdivision) {
	    if (subdivision == null) {
	        System.out.println("Subdivision is null, skipping subdivision rating update.");
	        return;
	    }

	    System.out.println("Updating Subdivision Rating for: " + subdivision.getName());

	    // Fetch all police stations in the same subdivision
	    List<PoliceStations> subdivisionPoliceStations = policeStationRepository.findAll().stream()
	            .filter(ps -> ps.getSubdivision() != null && ps.getSubdivision().getId().equals(subdivision.getId()))
	            .collect(Collectors.toList());

	    if (subdivisionPoliceStations.isEmpty()) {
	        System.out.println("No police stations found in subdivision. Setting rating to 0.");
	        subdivision.setRating(0);
	    } else {
	        double totalSubdivisionRating = subdivisionPoliceStations.stream()
	                .mapToDouble(PoliceStations::getPolicestationRating)
	                .average()
	                .orElse(0);
	        subdivision.setRating(totalSubdivisionRating);
	    }

	    System.out.println("Updated Subdivision Rating: " + subdivision.getRating());

	    // Save the updated subdivision rating within police stations
	    subdivisionPoliceStations.forEach(ps -> {
	        ps.setSubdivision(subdivision);
	        policeStationRepository.save(ps);
	    });

	    System.out.println("Subdivision rating updated successfully.");
	}

	private void updateHeadOfficeRating(HeadOffice headOffice) {
	    if (headOffice == null) {
	        System.out.println("Head Office is null, skipping head office rating update.");
	        return;
	    }

	    System.out.println("Updating Head Office Rating for: " + headOffice.getName());

	    // Fetch all police stations under subdivisions linked to this head office
	    List<PoliceStations> headOfficePoliceStations = policeStationRepository.findAll().stream()
	            .filter(ps -> ps.getHeadOffice() != null && ps.getHeadOffice().getId().equals(headOffice.getId()))
	            .collect(Collectors.toList());

	    if (headOfficePoliceStations.isEmpty()) {
	        System.out.println("No police stations found under head office. Setting rating to 0.");
	        headOffice.setRating(0);
	    } else {
	        double totalHeadOfficeRating = headOfficePoliceStations.stream()
	                .mapToDouble(ps -> ps.getSubdivision() != null ? ps.getSubdivision().getRating() : 0)
	                .average()
	                .orElse(0);
	        headOffice.setRating(totalHeadOfficeRating);
	    }

	    System.out.println("Updated Head Office Rating: " + headOffice.getRating());

	    // Save the updated head office rating within police stations
	    headOfficePoliceStations.forEach(ps -> {
	        ps.setHeadOffice(headOffice);
	        policeStationRepository.save(ps);
	    });

	    System.out.println("Head Office rating updated successfully.");
	}

	private int calculateResponseRating(long responseHours) {
	    System.out.println("Calculating response rating for response time: " + responseHours + " hours");

	    if (responseHours > 48) return 0;
	    else if (responseHours > 40) return 1;
	    else if (responseHours > 32) return 2;
	    else if (responseHours > 24) return 3;
	    else if (responseHours > 12) return 4;
	    else return 5;
	    
	    
	    
	    
	}
	
	
	@Override
	public double getPoliceStationResponseTimeRating(String policeStationId) {
	    Optional<PoliceStations> policeStationOpt = policeStationRepository.findById(policeStationId);
	    return policeStationOpt.map(PoliceStations::getPolicestationRating).orElse(0.0);
	}

	@Override
	public double getSubdivisionResponseTimeRating(String subdivisionId) {
	    List<PoliceStations> policeStations = policeStationRepository.findBySubdivisionId(subdivisionId);
	    return policeStations.stream().mapToDouble(PoliceStations::getPolicestationRating).average().orElse(0.0);
	}

	@Override
	public double getHeadOfficeResponseTimeRating(String headOfficeId) {
	    List<PoliceStations> policeStations = policeStationRepository.findByHeadOfficeId(headOfficeId);
	    return policeStations.stream().mapToDouble(PoliceStations::getPolicestationRating).average().orElse(0.0);
	}

	
	
}
	

