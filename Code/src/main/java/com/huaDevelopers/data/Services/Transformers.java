package com.huaDevelopers.data.Services;

import java.util.function.Function;

import com.huaDevelopers.data.Entities.Customer;
import com.huaDevelopers.data.Entities.History;
import com.huaDevelopers.data.Entities.Vehicle;
import com.huaDevelopers.data.Entities.External.ExternalCitizen;
import com.huaDevelopers.data.Entities.External.ExternalHistory;
import com.huaDevelopers.data.Entities.External.ExternalVehicle;

//Class the transform one object to another using Java SE8 attribute Function
//for a more detailed approach do visit https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html 
public class Transformers {

	// makes a function that transforms a ExternalVehicle object to a Vehicle
	// object
	public Function<ExternalVehicle, Vehicle> externalVToMyV = new Function<ExternalVehicle, Vehicle>() {

		public Vehicle apply(ExternalVehicle ext) {
			Vehicle vehicle = new Vehicle();
			vehicle.setLicensePlate(ext.getLicensePlate());
			vehicle.setReleaseDate(ext.getReleaseDate());
			vehicle.setColor(ext.getColor());
			vehicle.setCubic(ext.getCubic());
			vehicle.setType(ext.getType());
			vehicle.setCustomerPersonID(externalCitToMyCust.apply(ext.getCitizenPersonID()));

			return vehicle;
		}
	};

	// makes a function that transforms a ExternalCitizen object to a Customer
	// object
	public Function<ExternalCitizen, Customer> externalCitToMyCust = new Function<ExternalCitizen, Customer>() {

		// using apply build in method to set the proper attributes
		public Customer apply(ExternalCitizen ext) {
			Customer cust = new Customer();
			cust.setFirstName(ext.getFirstName());
			cust.setLastName(ext.getLastName());
			cust.setPersonalId(ext.getPersonalId());
			cust.setTrn(ext.getTrn());
			cust.setLicenseAqquired(ext.getLicenseAqquired());
			cust.setBirthdayDate(ext.getBirthdayDate());

			return cust;
		}
	};

	// makes a function that transforms a ExternalHistory object to a History
	// object
	public Function<ExternalHistory, History> externalHistToMyHist = new Function<ExternalHistory, History>() {

		public History apply(ExternalHistory ext) {
			History hist = new History();
			hist.setIncident(ext.getIncident());
			hist.setPersonalId(externalCitToMyCust.apply(ext.getPersonalId()));

			return hist;
		}
	};
}
