package com.springboot.DbsHackthon.model;

import java.util.List;

public class MarksResponse {

	private List<StudentMarks> marks;
	private Integer count;
	/**
	 * @param marks
	 * @param count
	 */
	public MarksResponse(List<StudentMarks> marks, Integer count) {
		this.marks = marks;
		this.count = count;
	}
	/**
	 * 
	 */
	public MarksResponse() {
		// TODO Auto-generated constructor stub
	}
	public List<StudentMarks> getMarks() {
		return marks;
	}
	public void setMarks(List<StudentMarks> marks) {
		this.marks = marks;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "MarksResponse [marks=" + marks + ", count=" + count + "]";
	}
	
	
	
}
