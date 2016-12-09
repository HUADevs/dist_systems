package com.huaDevelopers.data.Services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.huaDevelopers.dao.ServiceDAO;
import com.huaDevelopers.data.Entities.Service;

public class ServEntityServiceImpl implements ServEntityService{

	private ServiceDAO servDAO;
	
	public void setServDAO(ServiceDAO servDAO) {
		this.servDAO = servDAO;
	}
	
	@Override
	@Transactional
	public void addService(Service s) {
		this.servDAO.addService(s);	
	}

	@Override
	@Transactional
	public void updateService(Service s) {
		this.servDAO.updateService(s);
		
	}

	@Override
	@Transactional
	public Service getServiceByID(int id) {
		return this.servDAO.getServiceByID(id);
	}

	@Override
	@Transactional
	public List<Service> listAllServices() {
		return this.servDAO.listAllServices();
	}

	@Override
	@Transactional
	public void removeService(int id) {
		this.servDAO.removeService(id);
	}
	
}
