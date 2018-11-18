package com.springboot.dbshackathon.model;

import java.util.List;

public class HtmlToJson {


	private List<Type> type;
	private List<Object> object;
	/**
	 * @param type
	 * @param object
	 */
	public HtmlToJson(List<Type> type, List<Object> object) {
		this.type = type;
		this.object = object;
	}
	/**
	 * 
	 */
	public HtmlToJson() {
		// TODO Auto-generated constructor stub
	}
	public List<Type> getType() {
		return type;
	}
	public void setType(List<Type> type) {
		this.type = type;
	}
	public List<Object> getObject() {
		return object;
	}
	public void setObject(List<Object> object) {
		this.object = object;
	}
	@Override
	public String toString() {
		return "HtmlToJson [type=" + type + ", object=" + object + "]";
	}
	
	
	
}
