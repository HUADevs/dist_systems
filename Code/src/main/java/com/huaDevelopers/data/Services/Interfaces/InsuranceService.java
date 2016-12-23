package com.huaDevelopers.data.Services.Interfaces;

import java.util.List;

import com.huaDevelopers.data.Entities.Customer;
import com.huaDevelopers.data.Entities.Insurance;
import com.huaDevelopers.data.Entities.Vehicle;

public interface InsuranceService {

	public void addInsurance(Insurance insurance);

	public void updateInsurance(Insurance insurance);

	public Insurance getInsuranceByID(Long id);

	public Insurance getInsuranceByLicensePlate(String licensePlate);

	public List<Insurance> listAllInsurances();

	public void removeInsurance(Long id);

	public double countInsurCost(Vehicle vehicle, Customer cust, String type, int duration, boolean flag);
	
	public double countInsurDiscount(Customer cust, int duration);
		
	public boolean newDriver(Customer cust);

}
