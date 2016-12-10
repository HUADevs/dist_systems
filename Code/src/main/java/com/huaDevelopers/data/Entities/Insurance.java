package com.huaDevelopers.data.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Insurance")
public class Insurance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1118564151849532911L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private int id;
	
	@Column(name = "license_plate")
	private String LicensePlate;
	
	@Column(name = "date_start")
	private Date InsuranceDate;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "discount")
	private float discount;

	@Column(name = "type")
	private String Type;

	@Column(name = "new_driver")
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
