package com.huaDevelopers.controllers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
		return "vehicle_add";
	}

	@RequestMapping(value = "/findVehicle", method = RequestMethod.POST)
	public String saveCustomer(Model model, @Valid @ModelAttribute("vehicle") Vehicle vehicle, Errors errors) {
		if (errors.hasErrors() || vehicle.equals(null)) {
			System.out.println(errors);
			return "vehicle_add";
		} else {
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
	}

	@RequestMapping(value = "/{id}/create", method = RequestMethod.GET)
	public String addInsurance(@PathVariable("id") int id, Model model, @ModelAttribute("vehicle") Vehicle vehicle) {
		vehicle = this.vService.getVehicleByPID(id);
		Customer cust = this.customerService.getCustomerByID(vehicle.getCustomerPersonID().getPersonalId());
		model.addAttribute("customer", cust);
		id = vehicle.getId();
		model.addAttribute("id", id);
		model.addAttribute("vehicle", vehicle);
		Insurance insurance = new Insurance();
		insurance.setNewDriver(this.insuranceService.newDriver(cust));
		model.addAttribute("insurance", insurance);
		return "insur_add";
	}

	@RequestMapping(value = "/{id}/review", method = RequestMethod.POST)
	public String reviewInsurance(@PathVariable("id") int id, Model model,
			@ModelAttribute("insurance") Insurance insur) {
		int duration = insur.getDuration();
		String type = insur.getType();
		Vehicle vehicle = this.vService.getVehicleByPID(id);
		Customer cust = vehicle.getCustomerPersonID();
		insur.setInsuranceDate(LocalDate.now());
		insur.setPrice(this.insuranceService.countInsurCost(vehicle, cust, type, duration));
		insur.setDiscount(this.insuranceService.countInsurDiscount(cust, duration));
		model.addAttribute("customer", cust);
		model.addAttribute("vehicle", vehicle);
		model.addAttribute("insurance", insur);
		return "insur_review";

	}

	@ModelAttribute("typeOptions")
	public List<String> getTypes() {
		return new LinkedList<>(Arrays.asList(new String[] { "Basic", "Intermediate", "Premium" }));
	}

	@ModelAttribute("durationOptions")
	public List<Integer> getYears() {
		return new LinkedList<>(Arrays.asList(new Integer[] { 1, 2 }));
	}
}
