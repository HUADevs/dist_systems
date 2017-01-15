package com.huaDevelopers.data.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaDevelopers.dao.Interfaces.CustomerDAO;
import com.huaDevelopers.data.Entities.Customer;
import com.huaDevelopers.data.Services.Interfaces.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO custDAO;
	
	public void setCustDAO(CustomerDAO custDAO) {
		this.custDAO = custDAO;
	}

	@Override
	@Transactional
	public void addCustomer(Customer cust) {
		this.custDAO.addCustomer(cust);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer cust) {
		this.custDAO.updateCustomer(cust);
		
	}

	@Override
	@Transactional
	public Customer getCustomerByID(String personalId) {
		return this.custDAO.getCustomerByID(personalId);
	}

	@Override
	@Transactional
	public List<Customer> listAllCustomers() {
		return this.custDAO.listAllCustomers();
	}

	@Override
	@Transactional
	public void removeCustomer(Long id) {
		this.custDAO.removeCustomer(id);
	}

	@Override
	@Transactional
	public Customer getCustomerByEmail(String email) {
		return this.custDAO.getCustomerByEmail(email);
	}
	

}
