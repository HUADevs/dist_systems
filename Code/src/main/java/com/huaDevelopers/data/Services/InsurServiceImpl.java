package com.huaDevelopers.data.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaDevelopers.dao.Interfaces.InsuranceDAO;
import com.huaDevelopers.data.Entities.Customer;
import com.huaDevelopers.data.Entities.Insurance;
import com.huaDevelopers.data.Entities.Vehicle;
import com.huaDevelopers.data.Services.Interfaces.InsuranceService;

@Service
public class InsurServiceImpl implements InsuranceService {

	@Autowired
	private InsuranceDAO insurDAO;

	public void setInsurDAO(InsuranceDAO insurDAO) {
		this.insurDAO = insurDAO;
	}

	@Override
	@Transactional
	public void addInsurance(Insurance insurance) {
		this.insurDAO.addInsurance(insurance);
	}

	@Transactional
	@Override
	public void updateInsurance(Insurance insurance) {
		this.insurDAO.updateInsurance(insurance);
	}

	@Transactional
	@Override
	public Insurance getInsuranceByID(int id) {
		return this.insurDAO.getInsuranceByID(id);
	}

	@Transactional
	@Override
	public Insurance getInsuranceByLicensePlate(String licensePlate) {
		return this.insurDAO.getInsuranceByLicensePlate(licensePlate);
	}

	@Transactional
	@Override
	public List<Insurance> listAllInsurances() {
		return this.insurDAO.listAllInsurances();
	}

	@Transactional
	@Override
	public void removeInsurance(int id) {
		this.insurDAO.removeInsurance(id);
	}

	@Override
	@Transactional
	public float countInsurCost(Vehicle vehicle, Customer cust) {
		float cost = 0;
		int cubic = vehicle.getCubic();
		if (cubic <= 1000)
			cost = 250;
		else if (cubic <= 1400)
			cost = 300;
		else if (cubic <= 1800)
			cost = 350;
		else
			cost = 450;
		float discount = countInsurDiscount(cust);
		if (discount != 0)
			return cost * discount;
		return cost;
	}

	@Transactional
	public float countInsurDiscount(Customer cust) {
		float discount = 0;
		int exp = howManyYears(cust);
		for (int i = exp; i >= 0; i -= 10) {
			if (exp >= 10)
				discount = discount + 10 / 100;
		}
		return discount;
	}

	@Transactional
	public int howManyYears(Customer cust) {
		LocalDateTime initialDate = cust.getLicenseAqquired();
		int initialYear = initialDate.getYear();
		LocalDateTime now = LocalDateTime.now();
		int yearNow = now.getYear();
		return yearNow - initialYear;
	}

}
