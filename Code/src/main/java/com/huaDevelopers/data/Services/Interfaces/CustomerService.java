package com.huaDevelopers.data.Services.Interfaces;

import java.util.List;

import com.huaDevelopers.data.Entities.Customer;

public interface CustomerService {

	public void addCustomer(Customer cust);

	public void updateCustomer(Customer cust);

	public Customer getCustomerByID(String personalId);

	public List<Customer> listAllCustomers();

	public void removeCustomer(Long id);
}
