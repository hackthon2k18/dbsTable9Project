package com.springboot.dbshackathon.common;

public class SingleResponse {

	private String responseString;

	public SingleResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SingleResponse(String response) {
		super();
		this.responseString = response;
	}

	public String getResponse() {
		return responseString;
	}

	public void setResponse(String response) {
		this.responseString = response;
	}

	@Override
	public String toString() {
		return "SingleResponse [response=" + responseString + "]";
	}

}
