package com.system.policefeedback.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PoliceStations {
	
	private String Policestationname;
	private String PolicestationQRlink;
	private String PolicestationRating;
	private String PolicestationAddress;
	private double Policestationlatitude;
	private double Policestationlogintude;
	private String ContactNumber;

}
