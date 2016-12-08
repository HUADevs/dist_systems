package com.huaDevelopers.dao;

import java.util.List;

import com.huaDevelopers.data.Entities.Customer;

public interface CustomerDAO {

	public void addCustomer(Customer cust);

	public void updateCustomer(Customer cust);

	public Customer getCustomerByID(int id);

	public List<Customer> listAllCustomers();

	public void removeCustomer(int id);

}
