package com.huaDevelopers.data.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaDevelopers.dao.Interfaces.CustomerDAO;
import com.huaDevelopers.dao.Interfaces.ExternalDAO;
import com.huaDevelopers.dao.Interfaces.IncDAO;
import com.huaDevelopers.data.Entities.History;
import com.huaDevelopers.data.Entities.External.ExternalHistory;
import com.huaDevelopers.data.Services.Interfaces.IncService;

@Service
public class IncServiceImpl implements IncService {

	@Autowired
	private IncDAO incDAO;

	@Autowired
	private ExternalDAO externalDAO;

	@Autowired
	private CustomerDAO custDAO;

	public void setIncDAO(IncDAO incDAO) {
		this.incDAO = incDAO;
	}

	@Override
	@Transactional
	public void addIncident(History hr) {
		this.incDAO.addIncident(hr);
	}

	@Override
	@Transactional
	public void updateIncident(History hr) {
		this.incDAO.updateIncident(hr);
	}

	@Override
	@Transactional
	public History getIncidentByID(int id) {
		return this.incDAO.getIncidentByID(id);
	}

	@Override
	@Transactional
	public List<History> listAllIncidents() {
		return this.incDAO.listAllIncidents();
	}

	@Override
	@Transactional
	public List<History> listAllIncsPerCustomer(String CustId) {
		return this.incDAO.listAllIncsPerCustomer(CustId);
	}

	@Override
	@Transactional
	public void removeIncident(int id) {
		this.incDAO.removeIncident(id);
	}

	// if an existing customer decides to insur a new vehicle we automatically
	// update the history for that vehicle from the national db
	@Override
	@Transactional
	public void refreshCustomerIncidents(String personalId) {
		List<History> custHistory = this.incDAO.listAllIncsPerCustomer(personalId);
		for (History incident : custHistory) {
			this.incDAO.removeIncident(incident.getIncId());
		}
		List<ExternalHistory> ext = this.externalDAO.getHistoryList(personalId);
		Transformers bumblebee = new Transformers();
		List<History> hList = ext.stream().map(bumblebee.externalHistToMyHist).collect(Collectors.<History>toList());
		for (History incident : hList) {
			incident.setPersonalId(this.custDAO.getCustomerByID(incident.getPersonalId().getPersonalId()));
			this.incDAO.addIncident(incident);
		}
	}

}
