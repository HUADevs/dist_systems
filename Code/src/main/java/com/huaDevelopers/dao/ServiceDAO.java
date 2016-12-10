package com.huaDevelopers.dao;

import java.util.List;
import java.util.Set;

import com.huaDevelopers.data.Entities.Role;
import com.huaDevelopers.data.Entities.Service;

public interface ServiceDAO {

	public void addService (Service s);

	public void updateService (Service s);

	public Service getServiceByID(int id);
	
	public List<Service> listAllServices();

	public void removeService(int id);
	
	public Set<Role> getRoles();
	
	public void setRoles();
}
