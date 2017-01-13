package com.huaDevelopers.dao.Interfaces;

import java.util.List;

import com.huaDevelopers.data.Entities.Customer;

public interface CustomerDAO {

	public void addCustomer(Customer cust);

	public void updateCustomer(Customer cust);

	public Customer getCustomerByID(String id);

	public List<Customer> listAllCustomers();

	public void removeCustomer(Long id);

}
