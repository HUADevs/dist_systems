package com.huaDevelopers.data.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaDevelopers.dao.Interfaces.CustomerDAO;
import com.huaDevelopers.dao.Interfaces.VehicleDAO;
import com.huaDevelopers.data.Entities.Customer;
import com.huaDevelopers.data.Entities.Vehicle;
import com.huaDevelopers.data.Services.Interfaces.IncService;
import com.huaDevelopers.data.Services.Interfaces.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleDAO veDAO;

	public void setVeDAO(VehicleDAO veDAO) {
		this.veDAO = veDAO;
	}

	@Autowired
	private CustomerDAO custDAO;

	@Autowired
	private IncService incService;

	@Override
	@Transactional
	public void addVehicle(Vehicle v) {
		this.veDAO.addVehicle(v);
	}

	@Override
	@Transactional
	public void updateVehicle(Vehicle v) {
		this.veDAO.updateVehicle(v);
	}

	@Override
	@Transactional
	public Vehicle getVehicleByPID(Long id) {
		return this.veDAO.getVehicleByPID(id);
	}

	@Override
	@Transactional
	public Vehicle getVehicleByLP(String lp) {
		return this.veDAO.getVehicleByLP(lp);
	}

	@Override
	@Transactional
	public List<Vehicle> listAllVehicles() {
		return this.veDAO.listAllVehicles();
	}

	@Override
	@Transactional
	public void removeVehicle(String lp) {
		this.veDAO.removeVehicle(lp);
	}

	@Override
	@Transactional
	public Vehicle insertVehicle(Vehicle vehicle, Customer cust) {
		this.incService.refreshCustomerIncidents(cust.getPersonalId());
		vehicle.setCustomerPersonID(this.custDAO.getCustomerByID(vehicle.getCustomerPersonID().getPersonalId()));
		this.veDAO.addVehicle(vehicle);
		return vehicle;
	}

}
