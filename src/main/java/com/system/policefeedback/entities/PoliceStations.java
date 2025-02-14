package com.system.policefeedback.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document
public class PoliceStations {
	@Id
	private String id;
	private String policestationName;
	private String policestationQRLink;
	private double policestationRating; // Store the rating as a numeric value
	private String policestationAddress;
	private double policestationLatitude;
	private double policestationLongitude;
	private String contactNumber;

	// Embedded Subdivision
	private Subdivision subdivision;

	// Embedded Head Office
	private HeadOffice headOffice;

	// List of feedbacks for quick access
	private List<String> feedbackIds; // Store Feedback document IDs

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPolicestationName() {
		return policestationName;
	}

	public void setPolicestationName(String policestationName) {
		this.policestationName = policestationName;
	}

	public String getPolicestationQRLink() {
		return policestationQRLink;
	}

	public void setPolicestationQRLink(String policestationQRLink) {
		this.policestationQRLink = policestationQRLink;
	}

	public double getPolicestationRating() {
		return policestationRating;
	}

	public void setPolicestationRating(double policestationRating) {
		this.policestationRating = policestationRating;
	}

	public String getPolicestationAddress() {
		return policestationAddress;
	}

	public void setPolicestationAddress(String policestationAddress) {
		this.policestationAddress = policestationAddress;
	}

	public double getPolicestationLatitude() {
		return policestationLatitude;
	}

	public void setPolicestationLatitude(double policestationLatitude) {
		this.policestationLatitude = policestationLatitude;
	}

	public double getPolicestationLongitude() {
		return policestationLongitude;
	}

	public void setPolicestationLongitude(double policestationLongitude) {
		this.policestationLongitude = policestationLongitude;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Subdivision getSubdivision() {
		return subdivision;
	}

	public void setSubdivision(Subdivision subdivision) {
		this.subdivision = subdivision;
	}

	public HeadOffice getHeadOffice() {
		return headOffice;
	}

	public void setHeadOffice(HeadOffice headOffice) {
		this.headOffice = headOffice;
	}

	public List<String> getFeedbackIds() {
		return feedbackIds;
	}

	public void setFeedbackIds(List<String> feedbackIds) {
		this.feedbackIds = feedbackIds;
	}

	public PoliceStations(String id, String policestationName, String policestationQRLink, double policestationRating,
			String policestationAddress, double policestationLatitude, double policestationLongitude,
			String contactNumber, Subdivision subdivision, HeadOffice headOffice, List<String> feedbackIds) {
		super();
		this.id = id;
		this.policestationName = policestationName;
		this.policestationQRLink = policestationQRLink;
		this.policestationRating = policestationRating;
		this.policestationAddress = policestationAddress;
		this.policestationLatitude = policestationLatitude;
		this.policestationLongitude = policestationLongitude;
		this.contactNumber = contactNumber;
		this.subdivision = subdivision;
		this.headOffice = headOffice;
		this.feedbackIds = feedbackIds;
	}

	@Override
	public String toString() {
		return "PoliceStations [id=" + id + ", policestationName=" + policestationName + ", policestationQRLink="
				+ policestationQRLink + ", policestationRating=" + policestationRating + ", policestationAddress="
				+ policestationAddress + ", policestationLatitude=" + policestationLatitude
				+ ", policestationLongitude=" + policestationLongitude + ", contactNumber=" + contactNumber
				+ ", subdivision=" + subdivision + ", headOffice=" + headOffice + ", feedbackIds=" + feedbackIds + "]";
	}

	public PoliceStations() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Getters and Setters
	
	
}
