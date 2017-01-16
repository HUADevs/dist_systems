package com.huaDevelopers.controllers.Rest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huaDevelopers.data.Entities.Customer;
import com.huaDevelopers.data.Entities.Insurance;
import com.huaDevelopers.data.Entities.Vehicle;
import com.huaDevelopers.data.Services.Interfaces.CustomerService;
import com.huaDevelopers.data.Services.Interfaces.InsuranceService;
import com.huaDevelopers.data.Services.Interfaces.UserService;
import com.huaDevelopers.data.Services.Interfaces.VehicleService;

@RestController
@RequestMapping("/rest/insurance")
public class InsurRestController {

	@Autowired
	private InsuranceService insuranceService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private UserService userService;

	@Autowired
	private VehicleService vService;

	@GetMapping("/{username}/view")
	public List<Insurance> getInsurByUserEmail(@PathVariable("username") String id) {
		List<Insurance> insurances = new ArrayList<Insurance>();
		Customer cust = this.customerService
				.getCustomerByEmail(this.userService.getUserByUsername(id).getEmailAdress());
		System.out.println("Customer:" + cust.getFirstName() + " " + cust.getLastName());
		List<Vehicle> vehicles = this.vService.listAllVehiclesPerCustomer(cust.getPersonalId());
		for (Vehicle veh : vehicles) {
			System.out.println("Vehicle:" + veh.getLicensePlate());
			System.out.println(this.insuranceService.getInsuranceByID(veh.getId()));

			insurances.add(this.insuranceService.getInsuranceByID(veh.getId()));
		}
		return insurances;
	}

	@GetMapping("/{id:\\d+}")
	public Insurance getInsurance(@PathVariable("id") Long id) {

		Insurance insur = this.insuranceService.getInsuranceByID(id);

		if (!insur.getExpired().equals(this.insuranceService.checkExpiration(insur))) {
			insur.setExpired(this.insuranceService.checkExpiration(insur));
			this.insuranceService.updateInsurance(insur);
		}

		return insur;
	}

	@GetMapping("/{id:\\d+}/expand")
	public Insurance expandInsur(@PathVariable("id") Long id) {
		Insurance insur = this.insuranceService.getInsuranceByID(id);
		Vehicle vehicle = insur.getLicensePlate();
		Customer cust = vehicle.getCustomerPersonID();
		boolean flag = this.insuranceService.newDriver(cust);
		insur.setNewDriver(flag);
		return insur;
	}

	@PutMapping("/{id:\\d+}/expand")
	public Insurance expandInsurance(@PathVariable("id") Long id, @RequestBody Insurance JSONInsur) {
		Vehicle vehicle = JSONInsur.getLicensePlate();
		Customer cust = vehicle.getCustomerPersonID();
		int duration = JSONInsur.getDuration();
		String type = JSONInsur.getType();
		boolean flag = JSONInsur.getNewDriver();
		JSONInsur.setPrice(this.insuranceService.countInsurCost(vehicle, cust, type, duration, flag));
		JSONInsur.setDiscount(this.insuranceService.countInsurDiscount(cust, duration));
		JSONInsur.setNewDriver(flag);
		JSONInsur.setLicensePlate(vehicle);

		this.insuranceService.updateInsurance(JSONInsur);

		return JSONInsur;
	}

	@PutMapping("/{id:\\d+}/pay")
	public String payInsurance(@PathVariable("id") Long id, @RequestBody Insurance JSONInsur) {
		Vehicle vehicle = JSONInsur.getLicensePlate();
		Customer cust = vehicle.getCustomerPersonID();
		JSONInsur.setInsuranceDate(LocalDate.now());
		JSONInsur.setExpired(false);
		JSONInsur.setExpirationDate(this.insuranceService.expirationDateFunc(JSONInsur));
		JSONInsur.setPaid(true);

		this.insuranceService.updateInsurance(JSONInsur);

		String paymentCode = cust.getId() + "/" + vehicle.getLicensePlate();

		return paymentCode;

	}

}
