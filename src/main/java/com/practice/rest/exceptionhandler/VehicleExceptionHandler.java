package com.practice.rest.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.practice.rest.exceptions.VehicleNotFoundByIdException;
import com.practice.rest.exceptions.VehicleNotFoundByNameException;
import com.practice.rest.util.ErrorStructure;
import com.practice.rest.util.AppBuilder;

@RestControllerAdvice
public class VehicleExceptionHandler {
	AppBuilder responseBuilder;

	public VehicleExceptionHandler(AppBuilder responseBuilder) {
		super();
		this.responseBuilder = responseBuilder;
	}
	
	@ExceptionHandler(VehicleNotFoundByIdException.class)
	public ResponseEntity<ErrorStructure> handleVehicleNotFoundByIdException(VehicleNotFoundByIdException ex){
		return responseBuilder.create(HttpStatus.NOT_FOUND,ex.getMessage(),"Vehicle not found by Id");
	}
	
	@ExceptionHandler(VehicleNotFoundByNameException.class)
	public ResponseEntity<ErrorStructure> handleVehicleNotFoundByNameException(VehicleNotFoundByNameException ex){
		return responseBuilder.create(HttpStatus.NOT_FOUND,ex.getMessage(), "vehicle not found by name");
	}
}
