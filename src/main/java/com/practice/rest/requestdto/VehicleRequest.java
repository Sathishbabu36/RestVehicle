package com.practice.rest.requestdto;

import jakarta.validation.constraints.NotNull;

public class VehicleRequest {
	@NotNull(message = "vehicleName cannot be null")
	private String vehicleName;
	private String color;
	private String model;
	
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
}
