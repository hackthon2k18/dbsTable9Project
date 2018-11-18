package com.student.results.model;

public class Type {

	private String type;
	private String label;
	/**
	 * @param type
	 * @param label
	 */
	public Type(String type, String label) {
		this.type = type;
		this.label = label;
	}
	/**
	 * 
	 */
	public Type() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Type [type=" + type + ", label=" + label + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
