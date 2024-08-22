package com.practice.rest.exceptions;

@SuppressWarnings("serial")
public class VehicleNotFoundByIdException extends RuntimeException{
	private String message;

	public VehicleNotFoundByIdException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
