package com.huaDevelopers.data.Entities;

import java.io.Serializable;
import java.time.LocalDate;
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
	private String firstName;

	@NotEmpty
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@NotEmpty
	@Column(name = "personal_id", length = 8, unique = true, nullable = false)
	private String personalId;

	@Column(name = "birthday_date", nullable = false)
	private LocalDate birthdayDate;

	@Column(name = "tax_reg_number", unique = true, nullable = false)
	private int trn; // TAX REGISTRATION NUMBER

	@Column(name = "license_date", nullable = false)
	private LocalDate licenseAqquired;

	@OneToMany(mappedBy = "personalId")
	private Set<History> history;

	@OneToMany(mappedBy = "customerPersonID")
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
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPersonalId() {
		return personalId;
	}

	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}

	public LocalDate getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(LocalDate birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	public int getTrn() {
		return trn;
	}

	public void setTrn(int trn) {
		this.trn = trn;
	}

	public LocalDate getLicenseAqquired() {
		return licenseAqquired;
	}

	public void setLicenseAqquired(LocalDate licenseAqquired) {
		this.licenseAqquired = licenseAqquired;
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

	public static boolean isEqual(Object obj1, Object obj2) {
		return obj1 == obj2 || (obj1 != null && obj1.equals(obj2));
	}

}
