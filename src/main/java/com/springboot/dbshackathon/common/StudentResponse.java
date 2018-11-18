package com.springboot.dbshackathon.common;

import java.util.List;

import com.springboot.dbshackathon.model.Register;

public class StudentResponse {

	private List<Register> students;
	private Integer count;

	public StudentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentResponse(List<Register> students, Integer count) {
		super();
		this.students = students;
		this.count = count;
	}

	public List<Register> getStudents() {
		return students;
	}

	public void setStudents(List<Register> students) {
		this.students = students;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "StudentResponse [students=" + students + ", count=" + count + "]";
	}

}
