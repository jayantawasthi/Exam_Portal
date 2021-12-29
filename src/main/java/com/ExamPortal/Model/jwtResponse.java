package com.ExamPortal.Model;

public class jwtResponse {
	
	private String token;

	public jwtResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public jwtResponse() {
		super();
	}
	

}
