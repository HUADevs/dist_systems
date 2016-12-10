package com.huaDevelopers.data.Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaDevelopers.dao.DamFormDAO;
import com.huaDevelopers.data.Entities.DamageForm;

@Service
public class DFormServiceImpl implements DamFormService {

	private DamFormDAO formDAO;

	public void setFormDAO(DamFormDAO formDAO) {
		this.formDAO = formDAO;
	}

	@Override
	@Transactional
	public void addDamageForm(DamageForm dForm) {
		this.formDAO.addDamageForm(dForm);
	}

	@Override
	@Transactional
	public void updateDamageForm(DamageForm dForm) {
		this.formDAO.updateDamageForm(dForm);
	}

	@Override
	@Transactional
	public void deleteDamageForm(int id) {
		this.formDAO.deleteDamageForm(id);
	}

	@Override
	@Transactional
	public List<DamageForm> listDamageFormsPerVehicle(String plate) {
		return this.formDAO.listDamageFormsPerVehicle(plate);
	}

	@Override
	@Transactional
	public DamageForm getFormById(int id) {
		return this.formDAO.getFormById(id);
	}

	@Override
	@Transactional
	public List<DamageForm> listAllDamageForms() {
		return this.formDAO.listAllDamageForms();
	}

}
