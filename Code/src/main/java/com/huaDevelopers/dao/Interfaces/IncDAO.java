package com.huaDevelopers.dao.Interfaces;

import java.util.List;

import com.huaDevelopers.data.Entities.History;

public interface IncDAO {

	public void addIncident(History hr);

	public void updateIncident(History hr);

	public History getIncidentByID(int id);

	public List<History> listAllIncidents();

	public List<History> listAllIncsPerCustomer(String CustId);

	public void removeIncident(int id);

}
