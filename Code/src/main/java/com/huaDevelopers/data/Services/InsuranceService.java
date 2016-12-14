package com.huaDevelopers.data.Services;

import java.util.List;

import com.huaDevelopers.data.Entities.Customer;
import com.huaDevelopers.data.Entities.Insurance;
import com.huaDevelopers.data.Entities.Vehicle;

public interface InsuranceService {

	public void addInsurance(Insurance insurance);

	public void updateInsurance(Insurance insurance);

	public Insurance getInsuranceByID(int id);

	public Insurance getInsuranceByLicensePlate(String licensePlate);

	public List<Insurance> listAllInsurances();

	public void removeInsurance(int id);

	public float countInsCost(Vehicle vehicle, Customer cust);

}
