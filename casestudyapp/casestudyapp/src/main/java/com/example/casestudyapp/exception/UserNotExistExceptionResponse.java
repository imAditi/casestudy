package com.example.casestudyapp.exception;

public class UserNotExistExceptionResponse {

	private String id;
	
	public UserNotExistExceptionResponse(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
