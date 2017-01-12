package com.huaDevelopers.data.Services;

import java.time.LocalDate;
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
	public Insurance getInsuranceByID(Long id) {
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
	public void removeInsurance(Long id) {
		this.insurDAO.removeInsurance(id);
	}

	// count the final cost with extra costs and discounts
	@Override
	@Transactional
	public double countInsurCost(Vehicle vehicle, Customer cust, String type, int duration, boolean flag) {
		double cost = 0;
		int cubic = vehicle.getCubic();
		if (newDriver(cust) || flag)
			cost += 100;
		if (type.equals("Intermediate"))
			cost += 50;
		if (type.equals("Premium"))
			cost += 100;
		if (cubic <= 1000)
			cost += 250;
		else if (cubic <= 1400)
			cost += 300;
		else if (cubic <= 1800)
			cost += 350;
		else
			cost += 450;
		double discount = countInsurDiscount(cust, duration);
		if (duration == 2)
			cost *= 2;
		if (discount != 0)
			return cost - cost * discount;
		return cost;
	}

	// counts the specific discount
	@Override
	@Transactional
	public double countInsurDiscount(Customer cust, int duration) {
		double discount = 0;
		int exp = howManyYears(cust);
		while (exp >= 10) {
			discount = discount + (double) 10 / 100;
			exp -= 10;
		}
		if (duration == 2)
			discount = discount + (double) 20 / 100;
		return discount;
	}

	// counts how many years you are driver to ensure if you are qualified for
	// the ten year discount
	@Transactional
	public int howManyYears(Customer cust) {
		LocalDate initialDate = cust.getLicenseAqquired();
		int initialYear = initialDate.getYear();
		LocalDate now = LocalDate.now();
		int yearNow = now.getYear();
		return yearNow - initialYear;
	}

	// checks if the driver is under 23 and make sure that will take the extra
	// new Driver fee
	@Override
	@Transactional
	public boolean newDriver(Customer cust) {
		LocalDate birthday = cust.getBirthdayDate();
		int year = birthday.getYear();
		int day = birthday.getDayOfYear();
		LocalDate now = LocalDate.now();
		int yearNow = now.getYear();
		int dayNow = now.getDayOfYear();
		if ((yearNow - year < 23) && (dayNow > day))
			return true;
		return false;
	}

	@Override
	@Transactional
	public boolean checkExpiration(Insurance insur) {
		LocalDate startContract = insur.getInsuranceDate();
		int startYear = startContract.getYear();
		int startDay = startContract.getDayOfYear();
		LocalDate now = LocalDate.now();
		int yearNow = now.getYear();
		int dayNow = now.getDayOfYear();
		if (((yearNow - startYear == insur.getDuration()) && (dayNow > startDay))
				|| (yearNow - startYear > insur.getDuration()))
			return true;
		return false;
	}

	@Override
	@Transactional
	public LocalDate expirationDateFunc(Insurance insur) {
		LocalDate startContract = insur.getInsuranceDate();
		int startYear = startContract.getYear();
		int duration = insur.getDuration();
		int expireYear = startYear + duration;
		LocalDate endContract = LocalDate.ofYearDay(expireYear, startContract.getDayOfYear());
		return endContract;
	}
}
