package com.huaDevelopers.data.Entities;

import java.io.Serializable;
import java.time.LocalDateTime;
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

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty
	@Column(name = "first_name", nullable = false)
	private String FirstName;

	@NotEmpty
	@Column(name = "last_name", nullable = false)
	private String LastName;

	@NotEmpty
	@Column(name = "personal_id", length = 8, unique = true, nullable = false)
	private String PersonalId;

	@NotEmpty
	@Column(name = "tax_reg_number", unique = true, nullable = false)
	private int TRN; // TAX REGISTRATION NUMBER

	@NotEmpty
	@Column(name = "license_date", nullable = false)
	private LocalDateTime LicenseAqquired;

	@OneToMany(mappedBy = "PersonalId")
	private Set<History> history;

	@OneToMany(mappedBy = "CustomerPersonID")
	private Set<Vehicle> vehicles;

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

	public LocalDateTime getLicenseAqquired() {
		return LicenseAqquired;
	}

	public void setLicenseAqquired(LocalDateTime licenseAqquired) {
		LicenseAqquired = licenseAqquired;
	}

	public Set<History> getHistory() {
		return history;
	}

	public void setHistory(Set<History> history) {
		this.history = history;
	}

	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
