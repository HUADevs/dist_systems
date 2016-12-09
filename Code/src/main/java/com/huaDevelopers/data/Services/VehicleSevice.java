package com.huaDevelopers.data.Services;

import java.util.List;

import com.huaDevelopers.data.Entities.Vehicle;

public interface VehicleSevice {

	public void addVehicle(Vehicle v);

	public void updateVehicle(Vehicle v);
	
	public Vehicle getVehicleByPID(int id);
	
	public Vehicle getVehicleByLP(String lp);
	
	public List<Vehicle> listAllVehicles();

	public void removeVehicle(String lp);
}
