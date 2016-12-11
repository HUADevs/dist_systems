package com.huaDevelopers.data.Services;

import java.util.List;

import com.huaDevelopers.data.Entities.Insurance;

public interface InsuranceService {

	public void addInsurance(Insurance insurance);

	public void updateInsurance(Insurance insurance);

	public Insurance getInsuranceByID(int id);

	public Insurance getInsuranceByLicensePlate(String licensePlate);

	public List<Insurance> listAllInsurances();

	public void removeInsurance(int id);

}
