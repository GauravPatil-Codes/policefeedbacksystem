package com.system.policefeedback.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Feedback {
	@Id
	private String id;
    private String userName;
    private String contactNumber;
    private String concerneddepartment;
    private String purposeOfVisit;
    private String arrivalDate;
    private String arrivalTime;
    private String departureDate;
    private String departureTime;
    private int feedbackRating;
    private String feedbackComments;
    private double latitude;
    private double longitude;
    private String ip;
    private String policestationaddress;
    
    private String complaintStatus;
    private String subdepartmentremark;
    private String departmentremark;
    private String headofficeremark;
    private String expecteddateofresolution;
    private String issuedlicense;
    
    private LocalDateTime timestamp;
    private String policeStationId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getConcerneddepartment() {
		return concerneddepartment;
	}
	public void setConcerneddepartment(String concerneddepartment) {
		this.concerneddepartment = concerneddepartment;
	}
	public String getPurposeOfVisit() {
		return purposeOfVisit;
	}
	public void setPurposeOfVisit(String purposeOfVisit) {
		this.purposeOfVisit = purposeOfVisit;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public int getFeedbackRating() {
		return feedbackRating;
	}
	public void setFeedbackRating(int feedbackRating) {
		this.feedbackRating = feedbackRating;
	}
	public String getFeedbackComments() {
		return feedbackComments;
	}
	public void setFeedbackComments(String feedbackComments) {
		this.feedbackComments = feedbackComments;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPolicestationaddress() {
		return policestationaddress;
	}
	public void setPolicestationaddress(String policestationaddress) {
		this.policestationaddress = policestationaddress;
	}
	public String getComplaintStatus() {
		return complaintStatus;
	}
	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}
	public String getSubdepartmentremark() {
		return subdepartmentremark;
	}
	public void setSubdepartmentremark(String subdepartmentremark) {
		this.subdepartmentremark = subdepartmentremark;
	}
	public String getDepartmentremark() {
		return departmentremark;
	}
	public void setDepartmentremark(String departmentremark) {
		this.departmentremark = departmentremark;
	}
	public String getHeadofficeremark() {
		return headofficeremark;
	}
	public void setHeadofficeremark(String headofficeremark) {
		this.headofficeremark = headofficeremark;
	}
	public String getExpecteddateofresolution() {
		return expecteddateofresolution;
	}
	public void setExpecteddateofresolution(String expecteddateofresolution) {
		this.expecteddateofresolution = expecteddateofresolution;
	}
	public String getIssuedlicense() {
		return issuedlicense;
	}
	public void setIssuedlicense(String issuedlicense) {
		this.issuedlicense = issuedlicense;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getPoliceStationId() {
		return policeStationId;
	}
	public void setPoliceStationId(String policeStationId) {
		this.policeStationId = policeStationId;
	}
	public Feedback(String id, String userName, String contactNumber, String concerneddepartment, String purposeOfVisit,
			String arrivalDate, String arrivalTime, String departureDate, String departureTime, int feedbackRating,
			String feedbackComments, double latitude, double longitude, String ip, String policestationaddress,
			String complaintStatus, String subdepartmentremark, String departmentremark, String headofficeremark,
			String expecteddateofresolution, String issuedlicense, LocalDateTime timestamp, String policeStationId) {
		super();
		this.id = id;
		this.userName = userName;
		this.contactNumber = contactNumber;
		this.concerneddepartment = concerneddepartment;
		this.purposeOfVisit = purposeOfVisit;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.feedbackRating = feedbackRating;
		this.feedbackComments = feedbackComments;
		this.latitude = latitude;
		this.longitude = longitude;
		this.ip = ip;
		this.policestationaddress = policestationaddress;
		this.complaintStatus = complaintStatus;
		this.subdepartmentremark = subdepartmentremark;
		this.departmentremark = departmentremark;
		this.headofficeremark = headofficeremark;
		this.expecteddateofresolution = expecteddateofresolution;
		this.issuedlicense = issuedlicense;
		this.timestamp = timestamp;
		this.policeStationId = policeStationId;
	}
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", userName=" + userName + ", contactNumber=" + contactNumber
				+ ", concerneddepartment=" + concerneddepartment + ", purposeOfVisit=" + purposeOfVisit
				+ ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime + ", departureDate=" + departureDate
				+ ", departureTime=" + departureTime + ", feedbackRating=" + feedbackRating + ", feedbackComments="
				+ feedbackComments + ", latitude=" + latitude + ", longitude=" + longitude + ", ip=" + ip
				+ ", policestationaddress=" + policestationaddress + ", complaintStatus=" + complaintStatus
				+ ", subdepartmentremark=" + subdepartmentremark + ", departmentremark=" + departmentremark
				+ ", headofficeremark=" + headofficeremark + ", expecteddateofresolution=" + expecteddateofresolution
				+ ", issuedlicense=" + issuedlicense + ", timestamp=" + timestamp + ", policeStationId="
				+ policeStationId + "]";
	}
	

}
