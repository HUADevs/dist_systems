package com.huaDevelopers.data.Entities;

import java.io.Serializable;
import java.util.Date;

public class Insurance implements Serializable {

	private String LicensePlate;
	private Date InsuranceDate;
	private float price;
	private float discount;
	private String Type;
	private Boolean NewDriver;

	public Insurance() {
		// TODO Auto-generated constructor stub
	}

	public String getLicensePlate() {
		return LicensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		LicensePlate = licensePlate;
	}

	public Date getInsuranceDate() {
		return InsuranceDate;
	}

	public void setInsuranceDate(Date insuranceDate) {
		InsuranceDate = insuranceDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Boolean getNewDriver() {
		return NewDriver;
	}

	public void setNewDriver(Boolean newDriver) {
		NewDriver = newDriver;
	}

	
}
