package com.student.results.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_marks")
public class StudentMarks {
	@Id
	private Long id;
	private String name;
	private Integer c;
	private Integer java;
	private Integer python;
	private Integer linux;
	/**
	 * @param id
	 * @param name
	 * @param c
	 * @param java
	 * @param python
	 * @param linux
	 */
	public StudentMarks(Long id, String name, Integer c, Integer java, Integer python, Integer linux) {
		this.id = id;
		this.name = name;
		this.c = c;
		this.java = java;
		this.python = python;
		this.linux = linux;
	}
	
	/**
	 * @param c
	 * @param java
	 * @param python
	 * @param linux
	 */
	public StudentMarks(Integer c, Integer java, Integer python, Integer linux) {
		this.c = c;
		this.java = java;
		this.python = python;
		this.linux = linux;
	}

	/**
	 * 
	 */
	public StudentMarks() {
		// TODO Auto-generated constructor stub
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
	public Integer getC() {
		return c;
	}
	public void setC(Integer c) {
		this.c = c;
	}
	public Integer getJava() {
		return java;
	}
	public void setJava(Integer java) {
		this.java = java;
	}
	public Integer getPython() {
		return python;
	}
	public void setPython(Integer python) {
		this.python = python;
	}
	public Integer getLinux() {
		return linux;
	}
	public void setLinux(Integer linux) {
		this.linux = linux;
	}
	@Override
	public String toString() {
		return "StudentMarks [id=" + id + ", name=" + name + ", c=" + c + ", java=" + java + ", python=" + python
				+ ", linux=" + linux + "]";
	}
	
}
