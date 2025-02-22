package com.system.policefeedback.services;

import com.system.policefeedback.entities.Feedback;
import com.system.policefeedback.repositories.FeedbackRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    
    
    private PoliceStationServiceImpl policeStationService;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository, PoliceStationServiceImpl policeStationService) {
        this.feedbackRepository = feedbackRepository;
        this.policeStationService = policeStationService;
    }

    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public Page<Feedback> getAllFeedback(Pageable pageable) {
        return feedbackRepository.findAll(pageable);
    }

    @Override
    public Optional<Feedback> getFeedbackById(String id) {
        return feedbackRepository.findById(id);
    }

    @Override
    public Optional<Feedback> updateFeedback(String id, Feedback updatedFeedback) {
        return feedbackRepository.findById(id).map(existingFeedback -> {
            // Update basic user details
            existingFeedback.setUserName(updatedFeedback.getUserName());
            existingFeedback.setContactNumber(updatedFeedback.getContactNumber());
            existingFeedback.setConcerneddepartment(updatedFeedback.getConcerneddepartment());
            existingFeedback.setPurposeOfVisit(updatedFeedback.getPurposeOfVisit());
            existingFeedback.setArrivalDate(updatedFeedback.getArrivalDate());
            existingFeedback.setArrivalTime(updatedFeedback.getArrivalTime());
            existingFeedback.setDepartureDate(updatedFeedback.getDepartureDate());
            existingFeedback.setDepartureTime(updatedFeedback.getDepartureTime());
            existingFeedback.setUserfeedbackRating(updatedFeedback.getUserfeedbackRating());
            existingFeedback.setUserfeedbackComments(updatedFeedback.getUserfeedbackComments());
            existingFeedback.setUserlatitude(updatedFeedback.getUserlatitude());
            existingFeedback.setUserlongitude(updatedFeedback.getUserlongitude());
            existingFeedback.setUseraddress(updatedFeedback.getUseraddress());
            existingFeedback.setIp(updatedFeedback.getIp());
            existingFeedback.setUserSatisfied(updatedFeedback.getUserSatisfied());

            // Sub-department comments
            existingFeedback.setComplaintStatus(updatedFeedback.getComplaintStatus());
            existingFeedback.setSubdepartmentremark(updatedFeedback.getSubdepartmentremark());
            existingFeedback.setSubdepartmenttimestamp(updatedFeedback.getSubdepartmenttimestamp());

            // Department comments
            existingFeedback.setDepartmentremark(updatedFeedback.getDepartmentremark());
            existingFeedback.setDepartmenttimestamp(updatedFeedback.getDepartmenttimestamp());

            // Head Office comments
            existingFeedback.setHeadofficeremark(updatedFeedback.getHeadofficeremark());
            existingFeedback.setHeadofficetimestamp(updatedFeedback.getHeadofficetimestamp());
            existingFeedback.setExpecteddateofresolution(updatedFeedback.getExpecteddateofresolution());
            existingFeedback.setIssuedlicense(updatedFeedback.getIssuedlicense());

            // QR scan fields
            existingFeedback.setPolicestationname(updatedFeedback.getPolicestationname());
            existingFeedback.setPolicestationRating(updatedFeedback.getPolicestationRating());
            existingFeedback.setPolicestationAddress(updatedFeedback.getPolicestationAddress());
            existingFeedback.setPolicestationlatitude(updatedFeedback.getPolicestationlatitude());
            existingFeedback.setPolicestationlogintude(updatedFeedback.getPolicestationlogintude());
            existingFeedback.setPoliceStationId(updatedFeedback.getPoliceStationId());

            // Subdivision & Head Office references
            existingFeedback.setSubdivisionId(updatedFeedback.getSubdivisionId());
            existingFeedback.setHeadOfficeId(updatedFeedback.getHeadOfficeId());

            // Timestamp
            existingFeedback.setTimestamp(updatedFeedback.getTimestamp());

            // Save updated feedback
            Feedback savedFeedback = feedbackRepository.save(existingFeedback);

            // Update the police station rating
            policeStationService.updatePoliceStationRating(existingFeedback.getPoliceStationId());

            return savedFeedback;
        });
    }




    @Override
    public boolean deleteFeedback(String id) {
        return feedbackRepository.findById(id).map(feedback -> {
            feedbackRepository.delete(feedback);
            return true;
        }).orElse(false);
    }

	public List<Feedback> getFeedbackByPoliceStationId(String policeStationId) {
		// TODO Auto-generated method stub
		return feedbackRepository.findByPoliceStationId(policeStationId);
	}
	
	@Override
    public List<Feedback> getFeedbackByWeek() {
        LocalDateTime startOfWeek = LocalDate.now().with(java.time.DayOfWeek.MONDAY).atStartOfDay();
        LocalDateTime endOfWeek = startOfWeek.plusDays(7).with(LocalTime.MAX);
        return feedbackRepository.findByTimestampBetween(startOfWeek, endOfWeek);
    }

	@Override
	public List<Feedback> getFeedbackByMonth(String month) {
	    // Convert the month name to Month enum
	    Month requestedMonth;
	    try {
	        requestedMonth = Month.valueOf(month.toUpperCase());  // Convert "January" to Month.JANUARY
	    } catch (IllegalArgumentException e) {
	        throw new IllegalArgumentException("Invalid month name: " + month); // Handle invalid month
	    }

	    // Get current year (Assuming we're fetching for the current year)
	    int currentYear = LocalDate.now().getYear();

	    // Define the start and end of the requested month
	    LocalDateTime startOfMonth = LocalDate.of(currentYear, requestedMonth, 1).atStartOfDay();
	    LocalDateTime endOfMonth = startOfMonth.plusMonths(1).minusDays(1).with(LocalTime.MAX);

	    // Fetch filtered data
	    return feedbackRepository.findByTimestampBetween(startOfMonth, endOfMonth);
	}


    @Override
    public List<Feedback> getFeedbackByDate(LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = startOfDay.with(LocalTime.MAX);
        return feedbackRepository.findByTimestampBetween(startOfDay, endOfDay);
    }

    @Override
    public List<Feedback> getFeedbackByRating(double rating) {
        return feedbackRepository.findByUserfeedbackRating(rating);
    }

    @Override
    public List<Feedback> getFeedbackByPoliceStationName(String policeStationName) {
        return feedbackRepository.findByPolicestationnameContainingIgnoreCase(policeStationName);
    }

    @Override
    public List<Feedback> getFeedbackByUsername(String username) {
        return feedbackRepository.findByUserNameContainingIgnoreCase(username);
    }

    @Override
    public List<Feedback> searchFeedbackByKeyword(String keyword) {
        return feedbackRepository.searchFeedbackByKeyword(keyword);
    }
    
    @Override
    public List<Feedback> getFeedbackByHeadoffice(String headofficeId) {
        return feedbackRepository.findByHeadOfficeId(headofficeId);
    }

    @Override
    public List<Feedback> getFeedbackBySubdivision(String subdivisionId) {
        return feedbackRepository.findBySubdivisionId(subdivisionId);
    }

    @Override
    public double getAverageRatingByHeadoffice(String headofficeId) {
        List<Feedback> feedbackList = feedbackRepository.findByHeadOfficeId(headofficeId);
        return calculateAverageRating(feedbackList);
    }

    @Override
    public double getAverageRatingBySubdivision(String subdivisionId) {
        List<Feedback> feedbackList = feedbackRepository.findBySubdivisionId(subdivisionId);
        return calculateAverageRating(feedbackList);
    }

    @Override
    public double getAverageRatingByPoliceStation(String policeStationId) {
        List<Feedback> feedbackList = feedbackRepository.findByPoliceStationId(policeStationId);
        return calculateAverageRating(feedbackList);
    }

    private double calculateAverageRating(List<Feedback> feedbackList) {
        return feedbackList.stream().mapToDouble(Feedback::getUserfeedbackRating).average().orElse(0.0);
    }
    
    @Override
    public List<Feedback> getFeedbackByDepartment(String department) {
        return feedbackRepository.findByConcerneddepartment(department);
    }

    @Override
	public List<Feedback> getFeedbackBySubDivisionId(String subdivisionId) {
		// TODO Auto-generated method stub
		return feedbackRepository.findBySubdivisionId(subdivisionId);
	}

    
    @Override
    public double getUserSatisfiedRatingByPoliceStation(String policeStationId) {
        List<Feedback> feedbackList = feedbackRepository.findByPoliceStationId(policeStationId);
        return calculateUserSatisfactionRating(feedbackList);
    }

    @Override
    public double getUserSatisfiedRatingBySubdivision(String subdivisionId) {
        List<Feedback> feedbackList = feedbackRepository.findBySubdivisionId(subdivisionId);
        return calculateUserSatisfactionRating(feedbackList);
    }

    @Override
    public double getUserSatisfiedRatingByHeadOffice(String headOfficeId) {
        List<Feedback> feedbackList = feedbackRepository.findByHeadOfficeId(headOfficeId);
        return calculateUserSatisfactionRating(feedbackList);
    }

 // Helper method to calculate user satisfaction rating
    private double calculateUserSatisfactionRating(List<Feedback> feedbackList) {
        return feedbackList.stream()
                .mapToDouble(feedback -> "Yes".equalsIgnoreCase(feedback.getUserSatisfied()) ? 5.0 : 0.0)
                .average()
                .orElse(0.0);
    }
	

}
