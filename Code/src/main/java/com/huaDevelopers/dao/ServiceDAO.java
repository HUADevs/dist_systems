package com.huaDevelopers.dao;

import java.util.List;
import java.util.Set;

import com.huaDevelopers.data.Entities.Role;
import com.huaDevelopers.data.Entities.Services;

public interface ServiceDAO {

	public void addService (Services s);

	public void updateService (Services s);

	public Services getServiceByID(int id);
	
	public List<Services> listAllServices();

	public void removeService(int id);
	
	public Set<Role> getRoles();
	
	public void setRoles(Set<Role> roles);
}
