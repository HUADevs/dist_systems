package com.huaDevelopers.dao.Interfaces;

import java.util.List;

import com.huaDevelopers.data.Entities.DamageForm;

public interface DamFormDAO {

	public void addDamageForm(DamageForm dForm);

	public void updateDamageForm(DamageForm dForm);

	public void deleteDamageForm(int id);

	public List<DamageForm> listDamageFormsPerVehicle(Long v_id);

	public DamageForm getFormById(int id);

	public List<DamageForm> listAllDamageForms();
	
	public Long getFormCount(String role);

}
