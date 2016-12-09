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
@Table(name = "Customers")
public class Customer implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String FirstName;

	@Column(name = "last_name")
	private String LastName;

	@Column(name = "personal_id")
	private String PersonalId;

	@Column(name = "tax_reg_number")
	private int TRN; // TAX REGISTRATION NUMBER

	@Column(name = "license_date")
	private Date LicenseAqquired;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPersonalId() {
		return PersonalId;
	}

	public void setPersonalId(String personalId) {
		PersonalId = personalId;
	}

	public int getTRN() {
		return TRN;
	}

	public void setTRN(int tRN) {
		TRN = tRN;
	}

	public Date getLicenseAqquired() {
		return LicenseAqquired;
	}

	public void setLicenseAqquired(Date licenseAqquired) {
		LicenseAqquired = licenseAqquired;
	}

}
