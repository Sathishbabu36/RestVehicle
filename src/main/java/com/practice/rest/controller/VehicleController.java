package com.practice.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.rest.requestdto.VehicleRequest;
import com.practice.rest.responsedto.VehicleResponse;
import com.practice.rest.service.VehicleService;
import com.practice.rest.util.AppBuilder;
import com.practice.rest.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class VehicleController {

	VehicleService vehicleService;
	AppBuilder responseBuilder;


	public VehicleController(VehicleService vehicleService, AppBuilder responseBuilder) {
		super();
		this.vehicleService = vehicleService;
		this.responseBuilder=responseBuilder;
	}

	@Operation(description = "The API endpoint is used to save the vehicle",
			responses = {
					@ApiResponse(responseCode = "201", description = "Vehicle Created"),
					@ApiResponse(responseCode = "500", description = "Internal Server Error",
					content = {
							@Content(schema = @Schema(anyOf = RuntimeException.class)),
					})
	})
	@PostMapping("/vehicles")
	public ResponseEntity<ResponseStructure<VehicleResponse>> saveVehicle(@RequestBody VehicleRequest vehiclerequest) {
		VehicleResponse response = vehicleService.saveVehicle(vehiclerequest);
		return responseBuilder.success(HttpStatus.CREATED, "vehicle created", response);	
	}

	@Operation(
			description = "The API endpoint is used to find the vehicle",
			responses = {
					@ApiResponse(responseCode = "302", description = "Vehicle found"),
					@ApiResponse(responseCode = "500",description = "Internal server error",
					content= {
							@Content(schema = @Schema(anyOf = RuntimeException.class)),
					})
			})
	@GetMapping("/vehicles/{vehicleId}")
	public ResponseEntity<ResponseStructure<VehicleResponse>> findVehicleById(@PathVariable int vehicleId) {
		VehicleResponse response = vehicleService.findVehicleById(vehicleId);
		return responseBuilder.success(HttpStatus.FOUND,"Vehicle found", response);
	}

	@Operation(description = "The API endpoint is used to update the vehilce by using vehicleId",
			responses = {
					@ApiResponse(responseCode = "200", description = "vehicle updated"),
					@ApiResponse(responseCode = "500", description = "Internal server error",
					content= {
							@Content(schema = @Schema(anyOf = RuntimeException.class)),	
					})
	})
	@PutMapping("/vehicles/{vehicleId}")
	public ResponseEntity<ResponseStructure<VehicleResponse>> updateVehicle(@PathVariable int vehicleId,@RequestBody VehicleRequest vehicleRequest) {
		VehicleResponse response = vehicleService.updateVehicle(vehicleId,vehicleRequest);
		return responseBuilder.success(HttpStatus.OK, "Vehicle updated", response);
	}

	@Operation(description = "The API endpoint is used to delete the vehicle by using vehicleId",
			responses = {
					@ApiResponse(responseCode = "200", description = "vehicle deleted"),
					@ApiResponse(responseCode = "500", description = "Internal server error",
					content = {
							@Content(schema = @Schema(anyOf = RuntimeException.class))
					})
	})
	@DeleteMapping("/vehicles/{vehicleId}")
	public ResponseEntity<ResponseStructure<VehicleResponse>> deleteVehicle(@PathVariable int vehicleId) {
		VehicleResponse response = vehicleService.deleteVehicle(vehicleId);
		return responseBuilder.success(HttpStatus.OK, "Vehicle deleted", response);
	}

	@Operation(description = "The API endpoint is used to find all the vehicles",
			responses = {
					@ApiResponse(responseCode = "302", description = "All vehicles found"),
					@ApiResponse(responseCode = "500", description = "Internal server error",
					content = {
							@Content(schema = @Schema(anyOf = RuntimeException.class)),
					})
	})
	@GetMapping("/vehicles")
	public ResponseEntity<ResponseStructure<List<VehicleResponse>>> findAllVehicle(){
		List<VehicleResponse> response = vehicleService.findAllVehicle();
		return responseBuilder.success(HttpStatus.FOUND, "All Vehicle found", response);
	}

	@Operation(description = "The API endpoint is used to find vehicle by name",
			responses = {
					@ApiResponse(responseCode = "302", description = "vehicle found by name"),
					@ApiResponse(responseCode = "500", description = "Internal server error",
					content = {
							@Content(schema = @Schema(anyOf = RuntimeException.class))
					})
	})
	@GetMapping("/vehiclesbyname/{vehicleName}")
	public ResponseEntity<ResponseStructure<VehicleResponse>> findVehicleByName(@PathVariable String vehicleName){
		VehicleResponse response = vehicleService.findVehicleByName(vehicleName);
		return responseBuilder.success(HttpStatus.FOUND, "Vehicle found by name",response);
	}

	@Operation(description = "The API endpoint is used to find vehicle by model",
			responses = {
					@ApiResponse(responseCode = "302", description = "vehicle found by model"),
					@ApiResponse(responseCode = "500", description = "Internal server error",
					content = {
							@Content(schema = @Schema(anyOf = RuntimeException.class))
					})
	})
	@GetMapping("/vehicles/{model}")
	public ResponseEntity<ResponseStructure<VehicleResponse>> findVehicleByModel(@PathVariable String model){
		VehicleResponse response = vehicleService.findVehicleByModel(model);
		return responseBuilder.success(HttpStatus.FOUND, "Vehicle found by model",response);
	}

	@Operation(description = "The API end point is used to find vehicle by color and model",
			responses = {
					@ApiResponse(responseCode = "302", description = "vehicle found by color and model"),
					@ApiResponse(responseCode = "500", description = "Internal server error",
					content = {
							@Content(schema = @Schema(anyOf = RuntimeException.class))
					})
	})
	@GetMapping("/vehicles/{color}{model}")
	public ResponseEntity<ResponseStructure<VehicleResponse>> findVehiclByColorAndModel(@PathVariable String color,String model){
		VehicleResponse response = vehicleService.findVehicleByColorAndModel(color,model);
		return responseBuilder.success(HttpStatus.FOUND, "Vehicle found by color and model", response);
	}

	@Operation(description = "The API endpoint is used to find vehicle by name and color",
			responses = {
					@ApiResponse(responseCode = "302", description = "vehicle find by name and color"),
					@ApiResponse(responseCode = "500", description = "Internal server error",
					content = {
							@Content(schema = @Schema(anyOf = RuntimeException.class))
					})
	})
	@GetMapping("/vehicles/{vehicleName}{color}")
	public ResponseEntity<ResponseStructure<VehicleResponse>> findvehicleByVehicleNameAndColor(@PathVariable String vehicleName,String color){
		VehicleResponse response = vehicleService.findVehicleByVehicleNameAndColor(vehicleName,color);
		return responseBuilder.success(HttpStatus.FOUND, "Vehicle found by vehicleName and color", response);
	}
}
