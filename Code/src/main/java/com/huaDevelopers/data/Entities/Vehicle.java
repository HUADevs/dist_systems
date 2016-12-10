package com.huaDevelopers.data.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name="Vehicle")
public class Vehicle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1797310249072710177L;

	@Id
	@Column (name="license_plate")
	private String LicensePlate;
	
	@NotEmpty
	@Column (name="person_id", length=8, nullable=false)
	private String CustomerPersonID;
	
	@NotEmpty
	@Column (name="release_date", nullable=false)
	private Date ReleaseDate;
	
	@NotEmpty
	@Column (name="cubic", nullable=false)
	private int cubic;
	
	@NotEmpty
	@Column (name="type", nullable=false)
	private String Type;
	
	@NotEmpty
	@Column (name="color", nullable=false)
	private String color;
	
	private Set<DamageForm> dmgForms;
	
	private Insurance insurance;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	@ManyToOne
	@JoinColumn(name="person_id", nullable=false)
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

	@OneToMany(mappedBy="LicensePlate")
	public Set<DamageForm> getDmgForms() {
		return dmgForms;
	}

	public void setDmgForms(Set<DamageForm> dmgForms) {
		this.dmgForms = dmgForms;
	}

	@OneToOne(mappedBy="LicensePlate")
	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	
}
