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
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
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
            // User information
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

            // Sub-department comments
            existingFeedback.setComplaintStatus(updatedFeedback.getComplaintStatus());
            existingFeedback.setSubdepartmentremark(updatedFeedback.getSubdepartmentremark());

            // Department comments
            existingFeedback.setDepartmentremark(updatedFeedback.getDepartmentremark());

            // Headoffice comments
            existingFeedback.setHeadofficeremark(updatedFeedback.getHeadofficeremark());
            existingFeedback.setExpecteddateofresolution(updatedFeedback.getExpecteddateofresolution());
            existingFeedback.setIssuedlicense(updatedFeedback.getIssuedlicense());

            // QR scan fields
            existingFeedback.setPolicestationname(updatedFeedback.getPolicestationname());
            existingFeedback.setPolicestationRating(updatedFeedback.getPolicestationRating());
            existingFeedback.setPolicestationAddress(updatedFeedback.getPolicestationAddress());
            existingFeedback.setPolicestationlatitude(updatedFeedback.getPolicestationlatitude());
            existingFeedback.setPolicestationlogintude(updatedFeedback.getPolicestationlogintude());
            existingFeedback.setPoliceStationId(updatedFeedback.getPoliceStationId());

            // Timestamp
            existingFeedback.setTimestamp(updatedFeedback.getTimestamp());

            return feedbackRepository.save(existingFeedback);
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
    public List<Feedback> getFeedbackByMonth() {
        LocalDateTime startOfMonth = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        LocalDateTime endOfMonth = startOfMonth.plusMonths(1).minusDays(1).with(LocalTime.MAX);
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
}
