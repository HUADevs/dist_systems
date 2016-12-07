package com.huaDevelopers.data.Entities;

import java.io.Serializable;
import java.util.Date;

public class Vehicle implements Serializable{

	private String CustomerPersonID;
	private String LicensePlate;
	private Date ReleaseDate;
	private int cubic;
	private String Type;
	private String color;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public String getCustomerPersonID() {
		return CustomerPersonID;
	}

	public void setCustomerPersonID(String customerPersonID) {
		CustomerPersonID = customerPersonID;
	}

	public String getLicensePlate() {
		return LicensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		LicensePlate = licensePlate;
	}

	public Date getReleaseDate() {
		return ReleaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		ReleaseDate = releaseDate;
	}

	public int getCubic() {
		return cubic;
	}

	public void setCubic(int cubic) {
		this.cubic = cubic;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
}
