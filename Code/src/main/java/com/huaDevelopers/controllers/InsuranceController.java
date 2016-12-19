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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.huaDevelopers.data.Entities.Customer;
import com.huaDevelopers.data.Entities.Insurance;
import com.huaDevelopers.data.Entities.Vehicle;
import com.huaDevelopers.data.Entities.External.ExternalVehicle;
import com.huaDevelopers.data.Services.Transformers;
import com.huaDevelopers.data.Services.Interfaces.CustomerService;
import com.huaDevelopers.data.Services.Interfaces.ExternalService;
import com.huaDevelopers.data.Services.Interfaces.InsuranceService;
import com.huaDevelopers.data.Services.Interfaces.VehicleService;

@Controller
@RequestMapping("/cms/insurance")
@SessionAttributes("insurance")
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
		if (errors.hasErrors()) {
			System.out.println(errors);
			return "vehicle_add";
		} else if (ExternalVehicle.isEqual(this.externalService.getVehicle(vehicle.getLicensePlate()), null)) {
			System.out.println(errors);
			errors.rejectValue("licensePlate", "vehicle.licensePlate", "***This license plate does not exist***");
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
	public String reviewInsurance(@PathVariable("id") int id, Model model, @ModelAttribute("insurance") Insurance insur,
			Errors errors) {
		System.out.println("First id " + insur.getId());
		int duration = insur.getDuration();
		String type = insur.getType();
		boolean flag = insur.getNewDriver();
		Vehicle vehicle = this.vService.getVehicleByPID(id);
		Customer cust = vehicle.getCustomerPersonID();
		insur.setInsuranceDate(LocalDate.now());
		insur.setPrice(this.insuranceService.countInsurCost(vehicle, cust, type, duration, flag));
		insur.setDiscount(this.insuranceService.countInsurDiscount(cust, duration));
		insur.setNewDriver(flag);
		insur.setLicensePlate(vehicle);
		model.addAttribute("customer", cust);
		model.addAttribute("vehicle", vehicle);
		model.addAttribute("insurance", insur);
		return "insur_review";

	}

	@RequestMapping(value = "/{id}/save", method = RequestMethod.GET)
	public String saveInsurance(@PathVariable("id") int id, Model model, @ModelAttribute("insurance") Insurance insur,
			SessionStatus status) {
		System.out.println("id " + insur.getId());
		System.out.println("offer  " + insur.getDiscount());
		System.out.println("Price " + insur.getPrice());
		System.out.println("Type " + insur.getType());
		System.out.println("Duration " + insur.getDuration());
		System.out.println("Start " + insur.getInsuranceDate());
		System.out.println("Veh " + insur.getLicensePlate().getLicensePlate());
		System.out.println("New " + insur.getNewDriver());

		this.insuranceService.addInsurance(insur);
		model.addAttribute("insurance", insur);
		status.setComplete();
		return "insur_save";
	}

	@RequestMapping(value = "/view")
	public String viewAllInsurance(Model model) {
		model.addAttribute("insurances", this.insuranceService.listAllInsurances());
		return "insur_all";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	public String editInsurance(@PathVariable("id") int id, @ModelAttribute("insurance") Insurance insurance) {
		this.insuranceService.updateInsurance(insurance);
		return "insur_edit";
	}

	@RequestMapping(value = "/{id}/delete")
	public String deleteInsurance(@PathVariable("id") int id) {
		this.insuranceService.removeInsurance(id);
		return "redirect:/cms/insurance/view";
	}

	/*
	 * @ModelAttribute("insurance") public Insurance getInsurance() {
	 * System.out.println("Adding a new insurance to the model"); return new
	 * Insurance(); }
	 */

	@ModelAttribute("typeOptions")
	public List<String> getTypes() {
		return new LinkedList<>(Arrays.asList(new String[] { "Basic", "Intermediate", "Premium" }));
	}

	@ModelAttribute("durationOptions")
	public List<Integer> getYears() {
		return new LinkedList<>(Arrays.asList(new Integer[] { 1, 2 }));
	}
}
