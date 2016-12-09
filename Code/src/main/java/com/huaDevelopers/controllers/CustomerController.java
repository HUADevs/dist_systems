package com.huaDevelopers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaDevelopers.data.Entities.Customer;
import com.huaDevelopers.data.Services.CustomerService;

@Controller
@RequestMapping("/cms/customer")
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	@Qualifier(value = "customerService")
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addCustomer(Model model) {
	    model.addAttribute("customer", new Customer()); 
		return "template";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer cust) {
		if (cust.getId() == 0) {
			this.customerService.addCustomer(cust);
		} else {
			return "template";
		}

		return "test";

	}

}
