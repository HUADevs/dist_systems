package com.huaDevelopers.data.Services.Interfaces;

import java.util.List;

import com.huaDevelopers.data.Entities.Vehicle;

public interface VehicleService {

	public void addVehicle(Vehicle v);

	public void updateVehicle(Vehicle v);

	public Vehicle getVehicleByPID(int id);

	public Vehicle getVehicleByLP(String lp);

	public List<Vehicle> listAllVehicles();

	public void removeVehicle(String lp);

}
