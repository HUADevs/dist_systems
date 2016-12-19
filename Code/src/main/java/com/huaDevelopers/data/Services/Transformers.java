package com.huaDevelopers.data.Services;

import java.util.function.Function;

import com.huaDevelopers.data.Entities.Customer;
import com.huaDevelopers.data.Entities.History;
import com.huaDevelopers.data.Entities.Vehicle;
import com.huaDevelopers.data.Entities.External.ExternalCitizen;
import com.huaDevelopers.data.Entities.External.ExternalHistory;
import com.huaDevelopers.data.Entities.External.ExternalVehicle;

public class Transformers {

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
	
	public Function<ExternalCitizen, Customer> externalCitToMyCust = new Function<ExternalCitizen, Customer>() {

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

	public Function<ExternalHistory, History> externalHistToMyHist = new Function<ExternalHistory, History>() {

		public History apply(ExternalHistory ext) {
			History hist = new History();
			hist.setIncident(ext.getIncident());
			hist.setPersonalId(externalCitToMyCust.apply(ext.getPersonalId()));
			
			return hist;
		}
	};
}
