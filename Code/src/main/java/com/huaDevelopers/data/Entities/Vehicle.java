package com.huaDevelopers.data.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Vehicle")
public class Vehicle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1797310249072710177L;

	@Column (name="person_id")
	private String CustomerPersonID;
	
	@Id
	@Column (name="license_plate")
	private String LicensePlate;
	
	@Column (name="release_date")
	private Date ReleaseDate;
	
	@Column (name="cubic")
	private int cubic;
	
	@Column (name="type")
	private String Type;
	
	@Column (name="color")
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
