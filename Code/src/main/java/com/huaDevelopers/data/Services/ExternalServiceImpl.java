package com.huaDevelopers.data.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaDevelopers.dao.Interfaces.CustomerDAO;
import com.huaDevelopers.dao.Interfaces.ExternalDAO;
import com.huaDevelopers.dao.Interfaces.IncDAO;
import com.huaDevelopers.dao.Interfaces.VehicleDAO;
import com.huaDevelopers.data.Entities.Customer;
import com.huaDevelopers.data.Entities.History;
import com.huaDevelopers.data.Entities.Vehicle;
import com.huaDevelopers.data.Entities.External.ExternalCitizen;
import com.huaDevelopers.data.Entities.External.ExternalHistory;
import com.huaDevelopers.data.Entities.External.ExternalVehicle;
import com.huaDevelopers.data.Services.Interfaces.ExternalService;

@Service
public class ExternalServiceImpl implements ExternalService {

	@Autowired
	private ExternalDAO externalDAO;

	@Autowired
	private CustomerDAO custDAO;

	@Autowired
	private IncDAO incDAO;

	@Autowired
	private VehicleDAO veDAO;

	public void setVeDAO(VehicleDAO veDAO) {
		this.veDAO = veDAO;
	}

	public void setExternalDAO(ExternalDAO externalDAO) {
		this.externalDAO = externalDAO;
	}

	public void setCustDAO(CustomerDAO custDAO) {
		this.custDAO = custDAO;
	}

	public void setIncDAO(IncDAO incDAO) {
		this.incDAO = incDAO;
	}

	/*
	 * search the national db for citizen , vehicles and histories using
	 * Transformers it makes easy to obtain the correct objects and everything
	 * that we display in the user is from our database objects
	 */
	@Override
	@Transactional
	public Vehicle searchNationalDB(String lp) {
		Transformers optimusPrime = new Transformers();

		ExternalVehicle extV = this.externalDAO.getVehicle(lp);
		ExternalCitizen extCit = extV.getCitizenPersonID();

		List<ExternalHistory> extHistList = this.externalDAO.getHistoryList(extCit.getPersonalId());

		Vehicle vehicle = optimusPrime.externalVToMyV.apply(extV);
		Customer cust = optimusPrime.externalCitToMyCust.apply(extCit);

		List<History> hList = extHistList.stream().map(optimusPrime.externalHistToMyHist)
				.collect(Collectors.<History>toList());
		System.out.println(hList.size());
		Customer myCust = this.custDAO.getCustomerByID(cust.getPersonalId());
		if (!Customer.isEqual(myCust, cust)) {
			this.custDAO.addCustomer(cust);
		} else
			this.custDAO.updateCustomer(cust);
		vehicle.setCustomerPersonID(this.custDAO.getCustomerByID(vehicle.getCustomerPersonID().getPersonalId()));
		this.veDAO.addVehicle(vehicle);
		List<History> myList = this.incDAO.listAllIncsPerCustomer(cust.getPersonalId());
		if (myList.isEmpty()) {
			for (History incident : hList) {
				incident.setPersonalId(this.custDAO.getCustomerByID(incident.getPersonalId().getPersonalId()));
				this.incDAO.addIncident(incident);
			}
		}
		return vehicle;
	}

	@Override
	@Transactional
	public ExternalVehicle getVehicle(String lp) {
		return this.externalDAO.getVehicle(lp);
	}

}
