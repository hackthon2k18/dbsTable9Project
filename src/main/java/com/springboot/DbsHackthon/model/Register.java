package com.springboot.DbsHackthon.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "student_register")
public class Register {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String password;
	private String branch;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dob;
	private String address;

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Register(Long id, String name, String password, String branch, Date dob, String address) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.branch = branch;
		this.dob = dob;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "RegisterModel [id=" + id + ", name=" + name + ", password=" + password + ", branch=" + branch + ", dob="
				+ dob + ", address=" + address + "]";
	}

}
