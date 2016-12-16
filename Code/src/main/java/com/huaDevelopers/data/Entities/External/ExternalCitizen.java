package com.huaDevelopers.data.Entities.External;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Citizens")
public class ExternalCitizen implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3044422907846972065L;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Id
	@Column(name = "personal_id", length = 8)
	private String personalId;

	@Column(name = "tax_reg_number", unique = true, nullable = false)
	private int trn; // TAX REGISTRATION NUMBER

	@Column(name = "license_date", nullable = false)
	private LocalDateTime licenseAqquired;

	@OneToMany(mappedBy = "personalId")
	private Set<ExternalHistory> history;

	@OneToMany(mappedBy = "citizenPersonID")
	private Set<ExternalVehicle> vehicles;

	public ExternalCitizen() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPersonalId() {
		return personalId;
	}

	public int getTrn() {
		return trn;
	}

	public LocalDateTime getLicenseAqquired() {
		return licenseAqquired;
	}

	public Set<ExternalHistory> getHistory() {
		return history;
	}

	public Set<ExternalVehicle> getVehicles() {
		return vehicles;
	}

}
