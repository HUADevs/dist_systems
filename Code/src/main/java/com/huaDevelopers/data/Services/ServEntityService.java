package com.huaDevelopers.data.Services;

import java.util.List;

import com.huaDevelopers.data.Entities.Service;

public interface ServEntityService {

	public void addService (Service s);

	public void updateService (Service s);

	public Service getServiceByID(int id);
	
	public List<Service> listAllServices();

	public void removeService(int id);
	
}
