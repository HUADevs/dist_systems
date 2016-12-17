package com.huaDevelopers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huaDevelopers.data.Entities.Customer;
import com.huaDevelopers.data.Entities.Insurance;
import com.huaDevelopers.data.Entities.Vehicle;
import com.huaDevelopers.data.Services.Transformers;
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
		Transformers megatron = new Transformers();
		vehicle = megatron.externalVToMyV.apply(this.externalService.getVehicle(vehicle.getLicensePlate()));
		Customer cust = this.customerService.getCustomerByID(vehicle.getCustomerPersonID().getPersonalId());
		if (!Customer.isEqual(cust, null)) {
			vehicle = this.vService.insertVehicle(vehicle, cust);
		} else
			vehicle = this.externalService.searchNationalDB(vehicle.getLicensePlate());
		int id = vehicle.getId();
		model.addAttribute("id", id);
		model.addAttribute("vehicle", vehicle);
		return "redirect:/cms/insurance/{id}/create";
	}

	@RequestMapping(value = "/{id}/create", method = RequestMethod.GET)
	public String addInsurance(@PathVariable("id") int id, Model model, @ModelAttribute("vehicle") Vehicle vehicle) {
		vehicle = this.vService.getVehicleByPID(id);
		Customer cust = this.customerService.getCustomerByID(vehicle.getCustomerPersonID().getPersonalId());
		model.addAttribute("customer", cust);
		model.addAttribute("vehicle", vehicle);
		model.addAttribute("insurance", new Insurance());
		return "insur_add";
	}

	/*
	 * @RequestMapping(value = "/review", method = RequestMethod.POST) public
	 * String saveInsurance(@ModelAttribute("insurance") Insurance insur) { if
	 * (insur.getId() == 0) { this.insuranceService.addInsurance(insur); } else
	 * { return "template"; }
	 * 
	 * return "test";
	 * 
	 * }
	 */
}
