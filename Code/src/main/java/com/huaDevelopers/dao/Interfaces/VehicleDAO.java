package com.huaDevelopers.dao.Interfaces;

import java.util.List;

import com.huaDevelopers.data.Entities.Vehicle;


public interface VehicleDAO {

	public void addVehicle(Vehicle v);

	public void updateVehicle(Vehicle v);
	
	public Vehicle getVehicleByPID(Long id);
	
	public Vehicle getVehicleByLP(String lp);
	
	public List<Vehicle> listAllVehicles();

	public void removeVehicle(String lp);
}
