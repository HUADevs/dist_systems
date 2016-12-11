package com.huaDevelopers.data.Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaDevelopers.dao.VehicleDAO;
import com.huaDevelopers.data.Entities.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleDAO{

	private VehicleDAO vDAO;
	
	public void setVDAO(VehicleDAO vDAO) {
		this.vDAO = vDAO;
	}
	
	@Override
	@Transactional
	public void addVehicle(Vehicle v) {
		this.vDAO.addVehicle(v);
	}

	@Override
	@Transactional
	public void updateVehicle(Vehicle v) {
		this.vDAO.updateVehicle(v);
	}

	@Override
	@Transactional
	public Vehicle getVehicleByPID(int id) {
		return this.vDAO.getVehicleByPID(id);
	}

	@Override
	@Transactional
	public Vehicle getVehicleByLP(String lp) {
		return this.getVehicleByLP(lp);
	}

	@Override
	@Transactional
	public List<Vehicle> listAllVehicles() {
		return this.vDAO.listAllVehicles();
	}

	@Override
	@Transactional
	public void removeVehicle(String lp) {
		this.vDAO.removeVehicle(lp);
	}

}
