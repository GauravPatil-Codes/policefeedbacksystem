
package com.system.policefeedback.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    @Id
    private String id;
    private String username;
    private String password; // Stored as hashed
    private String role; // POLICE_DEPARTMENT, POLICE_SUB_DEPARTMENT, HEAD_OFFICE
    private String departmentName;
    private String contactNumber;
    
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public User(String id, String username, String password, String role, String departmentName, String contactNumber,
			boolean active) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.departmentName = departmentName;
		this.contactNumber = contactNumber;
		this.active = active;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", departmentName=" + departmentName + ", contactNumber=" + contactNumber + ", active=" + active
				+ "]";
	}

    // Getters and Setters
    
    
    
}
