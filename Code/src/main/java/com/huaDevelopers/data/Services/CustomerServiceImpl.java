package com.huaDevelopers.data.Services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.huaDevelopers.dao.CustomerDAO;
import com.huaDevelopers.data.Entities.Customer;

public class CustomerServiceImpl implements CustomerService {

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
	public Customer getCustomerByID(int id) {
		return this.custDAO.getCustomerByID(id);
	}

	@Override
	@Transactional
	public List<Customer> listAllCustomers() {
		return this.custDAO.listAllCustomers();
	}

	@Override
	@Transactional
	public void removeCustomer(int id) {
		this.custDAO.removeCustomer(id);
	}

}
