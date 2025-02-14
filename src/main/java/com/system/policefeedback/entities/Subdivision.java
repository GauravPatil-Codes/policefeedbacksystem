package com.system.policefeedback.entities;

public class Subdivision {


    private String id;
    private String name;
    private String address;
    private double rating; // Store rating for the subdivision
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public Subdivision(String id, String name, String address, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Subdivision [id=" + id + ", name=" + name + ", address=" + address + ", rating=" + rating + "]";
	}
	public Subdivision() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}