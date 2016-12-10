package com.huaDevelopers.data.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Customers")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3044422907846972065L;

	private int id;

	private String FirstName;

	private String LastName;

	private String PersonalId;

	private int TRN; // TAX REGISTRATION NUMBER

	private Date LicenseAqquired;

	private Set<History> history;

	private Set<Vehicle> vehicles;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NotEmpty
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	@NotEmpty
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	@NotEmpty
	@Column(name = "personal_id", length = 8, unique = true, nullable = false)
	public String getPersonalId() {
		return PersonalId;
	}

	public void setPersonalId(String personalId) {
		PersonalId = personalId;
	}

	@NotEmpty
	@Column(name = "tax_reg_number", unique = true, nullable = false)
	public int getTRN() {
		return TRN;
	}

	public void setTRN(int tRN) {
		TRN = tRN;
	}

	@NotEmpty
	@Column(name = "license_date", nullable = false)
	public Date getLicenseAqquired() {
		return LicenseAqquired;
	}

	public void setLicenseAqquired(Date licenseAqquired) {
		LicenseAqquired = licenseAqquired;
	}

	@OneToMany(mappedBy = "PersonalId")
	public Set<History> getHistory() {
		return history;
	}

	public void setHistory(Set<History> history) {
		this.history = history;
	}

	@OneToMany(mappedBy = "CustomerPersonID")
	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
