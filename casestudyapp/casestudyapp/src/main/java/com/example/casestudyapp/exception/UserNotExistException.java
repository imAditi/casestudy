package com.example.casestudyapp.exception;

public class UserNotExistException extends RuntimeException{

	public static final long serialversionId = 1L;
	
	public UserNotExistException(String message) {
		super(message);
	}
}
