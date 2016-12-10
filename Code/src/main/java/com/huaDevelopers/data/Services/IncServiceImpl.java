package com.huaDevelopers.data.Services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.huaDevelopers.dao.IncDAO;
import com.huaDevelopers.data.Entities.History;

public class IncServiceImpl implements IncService{

	private IncDAO incDAO;

	public void setIncDAO(IncDAO incDAO) {
		this.incDAO = incDAO;
	}

	@Override
	@Transactional
	public void addIncedent(History hr) {
		this.incDAO.addIncedent(hr);		
	}

	@Override
	@Transactional
	public void updateIncedent(History hr) {
		this.incDAO.updateIncedent(hr);		
	}

	@Override
	@Transactional
	public History getIncedentByID(int id) {
		return this.incDAO.getIncedentByID(id);
	}

	@Override
	@Transactional
	public List<History> listAllIncedents() {
		return this.incDAO.listAllIncedents();
	}

	@Override
	@Transactional
	public List<History> listAllIncsPerCustomer(String CustId) {
		return this.incDAO.listAllIncsPerCustomer(CustId);
	}

	@Override
	@Transactional
	public void removeIncedent(int id) {
		this.incDAO.removeIncedent(id);		
	}

}
