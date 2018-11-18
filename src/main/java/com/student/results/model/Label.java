package com.student.results.model;

public class Label {

	private String label;

	/**
	 * @param label
	 */
	public Label(String label) {
		this.label = label;
	}

	/**
	 * 
	 */
	public Label() {
		// TODO Auto-generated constructor stub
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Label [label=" + label + "]";
	}
	
	
}
