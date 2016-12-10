package com.huaDevelopers.data.Services;

import java.util.List;

import com.huaDevelopers.data.Entities.DamageForm;

public interface DamFormService {

	public void addDamageForm(DamageForm dForm);

	public void updateDamageForm(DamageForm dForm);

	public void deleteDamageForm(int id);

	public List<DamageForm> listDamageFormsPerVehicle(String plate);

	public DamageForm getFormById(int id);

	public List<DamageForm> listAllDamageForms();

}
