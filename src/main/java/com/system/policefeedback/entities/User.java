
package com.system.policefeedback.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    @Id
    private String id;
    private String username;
    private String password; // Stored as hashed
    private String role; // POLICE_DEPARTMENT, POLICE_SUB_DEPARTMENT, HEAD_OFFICE, Citizen
    private String departmentName;
    private String contactNumber;
    private String subDivisionId;
    private String subDivisionName;
    private String headOfficeId;
    private String headOfficeName;
    private String policeStationId;
    private String policeStationName;

    
    
    // Additional fields if required
    private boolean active = true;



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getDepartmentName() {
		return departmentName;
	}



	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}



	public String getContactNumber() {
		return contactNumber;
	}



	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}



	public String getSubDivisionId() {
		return subDivisionId;
	}



	public void setSubDivisionId(String subDivisionId) {
		this.subDivisionId = subDivisionId;
	}



	public String getSubDivisionName() {
		return subDivisionName;
	}



	public void setSubDivisionName(String subDivisionName) {
		this.subDivisionName = subDivisionName;
	}



	public String getHeadOfficeId() {
		return headOfficeId;
	}



	public void setHeadOfficeId(String headOfficeId) {
		this.headOfficeId = headOfficeId;
	}



	public String getHeadOfficeName() {
		return headOfficeName;
	}



	public void setHeadOfficeName(String headOfficeName) {
		this.headOfficeName = headOfficeName;
	}



	public String getPoliceStationId() {
		return policeStationId;
	}



	public void setPoliceStationId(String policeStationId) {
		this.policeStationId = policeStationId;
	}



	public String getPoliceStationName() {
		return policeStationName;
	}



	public void setPoliceStationName(String policeStationName) {
		this.policeStationName = policeStationName;
	}



	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}



	public User(String id, String username, String password, String role, String departmentName, String contactNumber,
			String subDivisionId, String subDivisionName, String headOfficeId, String headOfficeName,
			String policeStationId, String policeStationName, boolean active) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.departmentName = departmentName;
		this.contactNumber = contactNumber;
		this.subDivisionId = subDivisionId;
		this.subDivisionName = subDivisionName;
		this.headOfficeId = headOfficeId;
		this.headOfficeName = headOfficeName;
		this.policeStationId = policeStationId;
		this.policeStationName = policeStationName;
		this.active = active;
	}



	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", departmentName=" + departmentName + ", contactNumber=" + contactNumber + ", subDivisionId="
				+ subDivisionId + ", subDivisionName=" + subDivisionName + ", headOfficeId=" + headOfficeId
				+ ", headOfficeName=" + headOfficeName + ", policeStationId=" + policeStationId + ", policeStationName="
				+ policeStationName + ", active=" + active + "]";
	}

	
}
