package com.huaDevelopers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huaDevelopers.data.Entities.Insurance;
import com.huaDevelopers.data.Entities.Vehicle;
import com.huaDevelopers.data.Services.Interfaces.CustomerService;
import com.huaDevelopers.data.Services.Interfaces.ExternalService;
import com.huaDevelopers.data.Services.Interfaces.InsuranceService;
import com.huaDevelopers.data.Services.Interfaces.VehicleService;

@Controller
@RequestMapping("/cms/insurance")
public class InsuranceController {

	@Autowired
	private InsuranceService insuranceService;

	@Autowired
	private VehicleService vService;
	
	@Autowired
	private ExternalService externalService;
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/findVehicle", method = RequestMethod.GET)
	public String addCustomer(Model model) {
		model.addAttribute("vehicle", new Vehicle());
		return "cust_add";
	}

	@RequestMapping(value = "/findVehicle", method = RequestMethod.POST)
	public String saveCustomer(Model model, @ModelAttribute("vehicle") Vehicle vehicle) {
		
		Vehicle v = this.externalService.searchNationalDB(vehicle.getLicensePlate());
		model.addAttribute("vehicle", v);
		return "insur_add";
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
