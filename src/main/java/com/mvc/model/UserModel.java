package com.mvc.model;

import java.io.InputStream;

public class UserModel {
	private int id;
	private String name;
	private String mobile;
	private String email;
	private String hobby;
	private String gender;
	private String birthdate;
	private String password;
	private String cpassword;
	private String decryPass;
	private InputStream image;
	private int roletype;
	
	public int getRoletype() {
		return roletype;
	}
	public void setRoletype(int roletype) {
		this.roletype = roletype;
	}
	public String getDecryPass() {
		return decryPass;
	}
	public void setDecryPass(String decryPass) {
		this.decryPass = decryPass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
}
