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
    private Double userfeedbackRating;
    private String userfeedbackComments;
    private double userlatitude;
    private double userlongitude;
    private String useraddress;
    private String ip;
    
    //Sub department Comments
    private String complaintStatus;
    private String subdepartmentremark;
    //department Comments
    private String departmentremark;
    //Headoffice Comments
    private String headofficeremark;
    private String expecteddateofresolution;
    private String issuedlicense;
    
    //field which will we get onceQR is scanned
	private String policestationname;
	private String policestationRating;
	private String policestationAddress;
	private double policestationlatitude;
	private double policestationlogintude;
	private String policeStationId;
    
    private LocalDateTime timestamp;

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

	public Double getUserfeedbackRating() {
		return userfeedbackRating;
	}

	public void setUserfeedbackRating(Double userfeedbackRating) {
		this.userfeedbackRating = userfeedbackRating;
	}

	public String getUserfeedbackComments() {
		return userfeedbackComments;
	}

	public void setUserfeedbackComments(String userfeedbackComments) {
		this.userfeedbackComments = userfeedbackComments;
	}

	public double getUserlatitude() {
		return userlatitude;
	}

	public void setUserlatitude(double userlatitude) {
		this.userlatitude = userlatitude;
	}

	public double getUserlongitude() {
		return userlongitude;
	}

	public void setUserlongitude(double userlongitude) {
		this.userlongitude = userlongitude;
	}

	public String getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
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

	public String getPolicestationname() {
		return policestationname;
	}

	public void setPolicestationname(String policestationname) {
		this.policestationname = policestationname;
	}

	public String getPolicestationRating() {
		return policestationRating;
	}

	public void setPolicestationRating(String policestationRating) {
		this.policestationRating = policestationRating;
	}

	public String getPolicestationAddress() {
		return policestationAddress;
	}

	public void setPolicestationAddress(String policestationAddress) {
		this.policestationAddress = policestationAddress;
	}

	public double getPolicestationlatitude() {
		return policestationlatitude;
	}

	public void setPolicestationlatitude(double policestationlatitude) {
		this.policestationlatitude = policestationlatitude;
	}

	public double getPolicestationlogintude() {
		return policestationlogintude;
	}

	public void setPolicestationlogintude(double policestationlogintude) {
		this.policestationlogintude = policestationlogintude;
	}

	public String getPoliceStationId() {
		return policeStationId;
	}

	public void setPoliceStationId(String policeStationId) {
		this.policeStationId = policeStationId;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Feedback(String id, String userName, String contactNumber, String concerneddepartment, String purposeOfVisit,
			String arrivalDate, String arrivalTime, String departureDate, String departureTime,
			Double userfeedbackRating, String userfeedbackComments, double userlatitude, double userlongitude,
			String useraddress, String ip, String complaintStatus, String subdepartmentremark, String departmentremark,
			String headofficeremark, String expecteddateofresolution, String issuedlicense, String policestationname,
			String policestationRating, String policestationAddress, double policestationlatitude,
			double policestationlogintude, String policeStationId, LocalDateTime timestamp) {
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
		this.userfeedbackRating = userfeedbackRating;
		this.userfeedbackComments = userfeedbackComments;
		this.userlatitude = userlatitude;
		this.userlongitude = userlongitude;
		this.useraddress = useraddress;
		this.ip = ip;
		this.complaintStatus = complaintStatus;
		this.subdepartmentremark = subdepartmentremark;
		this.departmentremark = departmentremark;
		this.headofficeremark = headofficeremark;
		this.expecteddateofresolution = expecteddateofresolution;
		this.issuedlicense = issuedlicense;
		this.policestationname = policestationname;
		this.policestationRating = policestationRating;
		this.policestationAddress = policestationAddress;
		this.policestationlatitude = policestationlatitude;
		this.policestationlogintude = policestationlogintude;
		this.policeStationId = policeStationId;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", userName=" + userName + ", contactNumber=" + contactNumber
				+ ", concerneddepartment=" + concerneddepartment + ", purposeOfVisit=" + purposeOfVisit
				+ ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime + ", departureDate=" + departureDate
				+ ", departureTime=" + departureTime + ", userfeedbackRating=" + userfeedbackRating
				+ ", userfeedbackComments=" + userfeedbackComments + ", userlatitude=" + userlatitude
				+ ", userlongitude=" + userlongitude + ", useraddress=" + useraddress + ", ip=" + ip
				+ ", complaintStatus=" + complaintStatus + ", subdepartmentremark=" + subdepartmentremark
				+ ", departmentremark=" + departmentremark + ", headofficeremark=" + headofficeremark
				+ ", expecteddateofresolution=" + expecteddateofresolution + ", issuedlicense=" + issuedlicense
				+ ", policestationname=" + policestationname + ", policestationRating=" + policestationRating
				+ ", policestationAddress=" + policestationAddress + ", policestationlatitude=" + policestationlatitude
				+ ", policestationlogintude=" + policestationlogintude + ", policeStationId=" + policeStationId
				+ ", timestamp=" + timestamp + "]";
	}

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    
	
}
