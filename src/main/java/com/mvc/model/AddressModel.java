package com.mvc.model;

public class AddressModel {
	
	// Neddable variable fields
	private int userId;
	private String address;
	private String city;
	private String state;
	private String pincode;
	
	// Below methods for getter setter
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	/*
	private ArrayList<String> Address=new ArrayList<String>();
	private ArrayList<String> city=new ArrayList<String>();
	private ArrayList<String> state=new ArrayList<String>();
	private ArrayList<String> pincode=new ArrayList<String>();
	
	// Below for fields getter setter
	public ArrayList<String> getAddress() {
		return Address;
	}
	public void setAddress(ArrayList<String> address) {
		Address = address;
	}
	public ArrayList<String> getCity() {
		return city;
	}
	public void setCity(ArrayList<String> city) {
		this.city = city;
	}
	public ArrayList<String> getState() {
		return state;
	}
	public void setState(ArrayList<String> state) {
		this.state = state;
	}
	public ArrayList<String> getPincode() {
		return pincode;
	}
	public void setPincode(ArrayList<String> pincode) {
		this.pincode = pincode;
	}*/

}
