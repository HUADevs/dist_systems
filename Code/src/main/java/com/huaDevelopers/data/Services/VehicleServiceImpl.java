package com.huaDevelopers.data.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaDevelopers.dao.Interfaces.VehicleDAO;
import com.huaDevelopers.data.Entities.Vehicle;
import com.huaDevelopers.data.Services.Interfaces.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleDAO veDAO;

	public void setVeDAO(VehicleDAO veDAO) {
		this.veDAO = veDAO;
	}

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
	public Vehicle getVehicleByPID(int id) {
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

}
