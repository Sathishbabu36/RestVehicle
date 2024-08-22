package com.practice.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.practice.rest.model.Vehicle;
import com.practice.rest.requestdto.VehicleRequest;
import com.practice.rest.responsedto.VehicleResponse;

@Component
public class VehicleMapper {
	
	public Vehicle mapToVehicleEntity(VehicleRequest request,Vehicle vehicle ) {
		vehicle.setVehicleName(request.getVehicleName());
		vehicle.setColor(request.getColor());
		vehicle.setModel(request.getModel());
		
		return vehicle;
	}
	
	public VehicleResponse mapToResponse(Vehicle vehicle) {
		VehicleResponse response = new VehicleResponse();
		response.setVehicleName(vehicle.getVehicleName());
		response.setColor(vehicle.getColor());
		response.setModel(vehicle.getModel());
		
		return response;
	}
	
	public List<VehicleResponse> maptoResponses(List<Vehicle> vehicles){
		ArrayList<VehicleResponse> responses = new ArrayList<VehicleResponse>();
		
		for(Vehicle vehicle: vehicles) {
			VehicleResponse response = new VehicleResponse();
			response.setVehicleName(vehicle.getVehicleName());
			response.setColor(vehicle.getColor());
			response.setModel(vehicle.getModel());
			
			responses.add(response);
		}
		return responses;
	}
}
