package com.huaDevelopers.data.Services.Interfaces;

import java.util.List;

import com.huaDevelopers.data.Entities.Customer;
import com.huaDevelopers.data.Entities.Vehicle;

public interface VehicleService {

	public void addVehicle(Vehicle v);

	public void updateVehicle(Vehicle v);

	public Vehicle getVehicleByPID(Long id);

	public Vehicle getVehicleByLP(String lp);

	public List<Vehicle> listAllVehicles();

	public void removeVehicle(Long id);

	public Vehicle insertVehicle(Vehicle vehicle, Customer cust);

	public List<Vehicle> listAllVehiclesPerCustomer(String personalId);

}
