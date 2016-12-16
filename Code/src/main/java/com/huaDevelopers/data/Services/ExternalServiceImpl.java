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

	@Override
	@Transactional
	public Vehicle searchNationalDB(String lp) {
		System.out.println("blsgsgse");
		Transformers optimusPrime = new Transformers();
		System.out.println("pass trans");

		ExternalVehicle extV = this.externalDAO.getVehicle(lp);
		System.out.println("vehicle " + extV.getLicensePlate());

		ExternalCitizen extCit = extV.getCitizenPersonID();
		System.out.println("citizen " + extCit.getPersonalId());

		List<ExternalHistory> extHistList = this.externalDAO.getHistoryList(extCit.getPersonalId());
		System.out.println("pass first test");
		Vehicle vehicle = optimusPrime.externalVToMyV.apply(extV);
		System.out.println("pass second test with vehicle:"+vehicle.getLicensePlate());
		
		Customer cust = optimusPrime.externalCitToMyCust.apply(extCit);
		System.out.println("pass third test with customer:"+cust.getPersonalId());
		
		List<History> hList = extHistList.stream().map(optimusPrime.externalHistToMyHist)
				.collect(Collectors.<History> toList());
		System.out.println("pass fourth test with history:"+hList.size());

		System.out.println("pass fifth test with vehicle inserted");
		
		if (!cust.getPersonalId().equals(this.custDAO.getCustomerByID(cust.getPersonalId()))) {
			this.custDAO.addCustomer(cust);
		} else
			this.custDAO.updateCustomer(cust);
		
		this.veDAO.addVehicle(vehicle);

		if (hList.isEmpty()) {
			for (History incedent : hList) {
				this.incDAO.addIncedent(incedent);
			}
		} else {
			for (History incedent : hList) {
				this.incDAO.updateIncedent(incedent);
			}
		}
		return vehicle;
	}

}
