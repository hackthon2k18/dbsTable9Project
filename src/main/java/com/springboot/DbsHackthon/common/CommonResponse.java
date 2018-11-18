package com.springboot.DbsHackthon.common;

public class CommonResponse {

	private String response;
	private Long id;

	public CommonResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommonResponse(String response, Long id) {
		super();
		this.response = response;
		this.id = id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CommonResponse [response=" + response + ", id=" + id + "]";
	}

}
