package com.huaDevelopers.data.Services;

import java.util.List;

import com.huaDevelopers.data.Entities.History;

public interface IncService {

	public void addIncedent(History hr);

	public void updateIncedent(History hr);

	public History getIncedentByID(int id);

	public List<History> listAllIncedents();

	public List<History> listAllIncsPerCustomer(String CustId);

	public void removeIncedent(int id);
}
