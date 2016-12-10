package com.huaDevelopers.data.Services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.huaDevelopers.dao.InsuranceDAO;
import com.huaDevelopers.data.Entities.Insurance;

public class InsurServiceImpl implements InsuranceService {

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

}
