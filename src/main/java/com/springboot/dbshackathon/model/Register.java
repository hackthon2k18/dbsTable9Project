package com.springboot.dbshackathon.model;

public class Register {
	private Long userId;
	private String fullName;
	private Long mobileNumber;
	private String email;
	private String password;

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Register(Long userId, String fullName, Long mobileNumber, String email, String password) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Register [userId=" + userId + ", fullName=" + fullName + ", mobileNumber=" + mobileNumber + ", email="
				+ email + ", password=" + password + "]";
	}

}