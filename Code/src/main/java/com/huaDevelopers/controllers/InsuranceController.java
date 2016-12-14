package com.huaDevelopers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huaDevelopers.data.Entities.Customer;
import com.huaDevelopers.data.Entities.Insurance;
import com.huaDevelopers.data.Entities.Vehicle;
import com.huaDevelopers.data.Services.InsuranceService;

@Controller
@RequestMapping("/cms/insurance")
public class InsuranceController {

	private InsuranceService insuranceService;

	@Autowired
	@Qualifier(value = "insuranceService")
	public void setInsuranceService(InsuranceService insuranceService) {
		this.insuranceService = insuranceService;
	}

	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("vehicle", new Vehicle());
		return "cust_add";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String saveCustomer(Model model) {
		
		return "cust_add";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String addInsurance(Model model) {
		model.addAttribute("insurance", new Insurance());
		return "insur_add";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String saveInsurance(@ModelAttribute("insurance") Insurance insur) {
		if (insur.getId() == 0) {
			this.insuranceService.addInsurance(insur);
		} else {
			return "template";
		}

		return "test";

	}
}
