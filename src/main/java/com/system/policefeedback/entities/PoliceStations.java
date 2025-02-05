package com.system.policefeedback.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
public class PoliceStations {
	@Id
	private String id;
	private String Policestationname;
	private String PolicestationQRlink;
	private String PolicestationRating;
	private String PolicestationAddress;
	private double Policestationlatitude;
	private double Policestationlogintude;
	private String ContactNumber;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		id = id;
	}
	public String getPolicestationname() {
		return Policestationname;
	}
	public void setPolicestationname(String policestationname) {
		Policestationname = policestationname;
	}
	public String getPolicestationQRlink() {
		return PolicestationQRlink;
	}
	public void setPolicestationQRlink(String policestationQRlink) {
		PolicestationQRlink = policestationQRlink;
	}
	public String getPolicestationRating() {
		return PolicestationRating;
	}
	public void setPolicestationRating(String policestationRating) {
		PolicestationRating = policestationRating;
	}
	public String getPolicestationAddress() {
		return PolicestationAddress;
	}
	public void setPolicestationAddress(String policestationAddress) {
		PolicestationAddress = policestationAddress;
	}
	public double getPolicestationlatitude() {
		return Policestationlatitude;
	}
	public void setPolicestationlatitude(double policestationlatitude) {
		Policestationlatitude = policestationlatitude;
	}
	public double getPolicestationlogintude() {
		return Policestationlogintude;
	}
	public void setPolicestationlogintude(double policestationlogintude) {
		Policestationlogintude = policestationlogintude;
	}
	public String getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}
	public PoliceStations(String id, String policestationname, String policestationQRlink, String policestationRating,
			String policestationAddress, double policestationlatitude, double policestationlogintude,
			String contactNumber) {
		super();
		id = id;
		Policestationname = policestationname;
		PolicestationQRlink = policestationQRlink;
		PolicestationRating = policestationRating;
		PolicestationAddress = policestationAddress;
		Policestationlatitude = policestationlatitude;
		Policestationlogintude = policestationlogintude;
		ContactNumber = contactNumber;
	}
	public PoliceStations() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PoliceStations [Id=" + id + ", Policestationname=" + Policestationname + ", PolicestationQRlink="
				+ PolicestationQRlink + ", PolicestationRating=" + PolicestationRating + ", PolicestationAddress="
				+ PolicestationAddress + ", Policestationlatitude=" + Policestationlatitude
				+ ", Policestationlogintude=" + Policestationlogintude + ", ContactNumber=" + ContactNumber + "]";
	}
	
	
	
	
	
	
}


