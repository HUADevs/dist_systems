package com.huaDevelopers.dao;

import com.huaDevelopers.data.Entities.Vehicle;


public interface VehicleDAO {

	public void addVehicle(Vehicle v);

	public void updateVehicle(Vehicle v);

	public void removeVehicle(int id);
}
