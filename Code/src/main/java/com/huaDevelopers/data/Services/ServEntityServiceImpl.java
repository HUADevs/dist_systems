package com.huaDevelopers.data.Services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaDevelopers.dao.ServiceDAO;
import com.huaDevelopers.data.Entities.Role;
import com.huaDevelopers.data.Entities.Services;

@Service
public class ServEntityServiceImpl implements ServEntityService{

	private ServiceDAO servDAO;
	
	public void setServDAO(ServiceDAO servDAO) {
		this.servDAO = servDAO;
	}
	
	@Override
	@Transactional
	public void addService(Services s) {
		this.servDAO.addService(s);	
	}

	@Override
	@Transactional
	public void updateService(Services s) {
		this.servDAO.updateService(s);
		
	}

	@Override
	@Transactional
	public Services getServiceByID(int id) {
		return this.servDAO.getServiceByID(id);
	}

	@Override
	@Transactional
	public List<Services> listAllServices() {
		return this.servDAO.listAllServices();
	}

	@Override
	@Transactional
	public void removeService(int id) {
		this.servDAO.removeService(id);
	}

	@Override
	public Set<Role> getRoles() {
		return this.servDAO.getRoles();
	}

	@Override
	public void setRoles() {
		this.servDAO.setRoles();
	}
	
}
