package com.huaDevelopers.data.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaDevelopers.dao.Interfaces.DamFormDAO;
import com.huaDevelopers.data.Entities.DamageForm;
import com.huaDevelopers.data.Services.Interfaces.DamFormService;

@Service
public class DFormServiceImpl implements DamFormService {

	@Autowired
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
	public List<DamageForm> listDamageFormsPerVehicle(Long v_id) {
		return this.formDAO.listDamageFormsPerVehicle(v_id);
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

	@Override
	@Transactional
	public Long getFormCount(String role) {
		return this.formDAO.getFormCount(role);
	}

}
