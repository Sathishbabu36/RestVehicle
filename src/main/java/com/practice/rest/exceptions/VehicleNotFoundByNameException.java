package com.practice.rest.exceptions;

@SuppressWarnings("serial")
public class VehicleNotFoundByNameException extends RuntimeException {
	String message;

	public VehicleNotFoundByNameException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
