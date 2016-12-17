package com.huaDevelopers.data.Services.Interfaces;

import java.util.List;

import com.huaDevelopers.data.Entities.History;

public interface IncService {

	public void addIncident(History hr);

	public void updateIncident(History hr);

	public History getIncidentByID(int id);

	public List<History> listAllIncidents();

	public List<History> listAllIncsPerCustomer(String CustId);

	public void removeIncident(int id);

	public void refreshCustomerIncidents(String personalId);

}
