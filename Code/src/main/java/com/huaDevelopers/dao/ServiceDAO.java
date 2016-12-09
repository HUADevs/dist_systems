package com.huaDevelopers.dao;

import java.util.List;

import com.huaDevelopers.data.Entities.Service;
import com.huaDevelopers.data.Entities.User;

public interface ServiceDAO {

	public void addService (Service s);

	public void updateService (Service s);

	public Service getServiceByID(int id);
	
	public List<Service> listAllServices();

	public void removeService(int id);
}
