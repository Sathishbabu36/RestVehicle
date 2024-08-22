package com.practice.rest.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.dialect.function.AvgFunction.ReturnTypeResolver;
import org.springframework.stereotype.Service;

import com.practice.rest.exceptions.VehicleNotFoundByIdException;
import com.practice.rest.exceptions.VehicleNotFoundByNameException;
import com.practice.rest.mapper.VehicleMapper;
import com.practice.rest.model.Vehicle;
import com.practice.rest.repository.VehicleRepo;
import com.practice.rest.requestdto.VehicleRequest;
import com.practice.rest.responsedto.VehicleResponse;

@Service
public class VehicleService {
	VehicleRepo vehicleRepo;
	VehicleMapper vehicleMapper;

	public VehicleService(VehicleRepo vehicleRepo,VehicleMapper vehicleMapper) {
		super();
		this.vehicleRepo = vehicleRepo;
		this.vehicleMapper=vehicleMapper;
	}

	public VehicleResponse saveVehicle(VehicleRequest vehiclerequest) {
		Vehicle vehicle = vehicleMapper.mapToVehicleEntity(vehiclerequest,new Vehicle());
		vehicleRepo.save(vehicle);
		return vehicleMapper.mapToResponse(vehicle);
	}

	public VehicleResponse findVehicleById(int vehicleId) {
		return vehicleRepo.findById(vehicleId).map(vehicle -> vehicleMapper.mapToResponse(vehicle))
				.orElseThrow(()->new VehicleNotFoundByIdException("failed to find Vehicle"));
	}

	public VehicleResponse updateVehicle(int vehicleId,VehicleRequest vehicleRequest) {
		return vehicleRepo.findById(vehicleId)
				.map(exVehicle ->{ 
					vehicleMapper.mapToVehicleEntity(vehicleRequest, exVehicle);
					exVehicle = vehicleRepo.save(exVehicle);
					return vehicleMapper.mapToResponse(exVehicle);
				}).orElseThrow(()->new VehicleNotFoundByIdException("Vehicle not updated"));
	}

	public List<VehicleResponse> findAllVehicle() {
		return vehicleRepo.findAll()
				.stream()
				.filter(vehicle -> vehicle
						.getVehicleName()!=null)
				.map(vehicle -> vehicleMapper.mapToResponse(vehicle))
				.toList();

	}

	public VehicleResponse deleteVehicle(int vehicleId) {
		return vehicleRepo.findById(vehicleId)
				.map(vehicle ->{
					vehicleRepo.delete(vehicle);
					return vehicleMapper.mapToResponse(vehicle);
				}).orElseThrow(()-> new VehicleNotFoundByIdException("vehicle Not deleted"));
	}		

	public VehicleResponse findVehicleByName(String vehicleName) {
		return vehicleRepo.findByVehicleName(vehicleName)
				.map(vehicle -> vehicleMapper.mapToResponse(vehicle))
				.orElseThrow(()->new VehicleNotFoundByIdException("Vehicle not found By Name"));
	}

	public VehicleResponse findVehicleByModel(String model) {
		return vehicleRepo.findByModel(model)
				.map(vehicle -> vehicleMapper.mapToResponse(vehicle))
				.orElseThrow(()-> new VehicleNotFoundByIdException("Vehicle not foud By Model"));
	}
	public VehicleResponse findVehicleByColorAndModel(String color, String model) {
		return vehicleRepo.findByColorAndModel(color, model)
				.map(vehicle -> vehicleMapper.mapToResponse(vehicle))
				.orElseThrow(()-> new VehicleNotFoundByIdException("vehicle not found by color and model"));
	}

	public VehicleResponse findVehicleByVehicleNameAndColor(String vehicleName, String color) {
		return vehicleRepo.findByVehicleNameAndColor(vehicleName, color)
				.map(vehicle -> vehicleMapper.mapToResponse(vehicle))
				.orElseThrow(()->new VehicleNotFoundByIdException("vehicle not found by vehicleName and color"));
	}
}
