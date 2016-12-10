package com.huaDevelopers.data.Services;

import java.util.List;

import com.huaDevelopers.data.Entities.Customer;

public interface CustomerService {

	public void addCustomer(Customer cust);

	public void updateCustomer(Customer cust);

	public Customer getCustomerByID(int id);

	public List<Customer> listAllCustomers();

	public void removeCustomer(int id);
}