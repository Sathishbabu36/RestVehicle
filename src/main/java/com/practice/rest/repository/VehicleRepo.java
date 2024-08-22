package com.practice.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practice.rest.model.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer>{
	@Query("from Vehicle where vehicleName=:vehicle_name")
	Optional<Vehicle> findByVehicleName(String vehicle_name);
	
	@Query("from Vehicle where color=:color ")
	Optional<Vehicle> findByColor(String color);
	
	@Query("from Vehicle where model=:model ")
	Optional<Vehicle> findByModel(String model);
	
	@Query("from Vehicle where color=:color and model=:model")
	Optional<Vehicle> findByColorAndModel(String color,String model);
	
	@Query("from Vehicle where vehicleName=:vehicle_name and color=:color")
	Optional<Vehicle> findByVehicleNameAndColor(String vehicle_name,String color);
}
