package com.huaDevelopers.data.Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Vehicle")
public class Vehicle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1797310249072710177L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_id")
	private int id;

	@NotEmpty
	@Column(name = "license_plate", length = 7, nullable = false)
	private String licensePlate;

	@ManyToOne
	@JoinColumn(name = "person_id", nullable = false, referencedColumnName = "personal_id")
	private Customer customerPersonID;

	@Column(name = "release_date", nullable = false)
	private LocalDate releaseDate;

	@Column(name = "cubic", nullable = false)
	private int cubic;

	@NotEmpty
	@Column(name = "type", nullable = false)
	private String type;

	@NotEmpty
	@Column(name = "color", nullable = false)
	private String color;

	@OneToMany(mappedBy = "licensePlate")
	private Set<DamageForm> dmgForms;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Insurance insurance;

	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Customer getCustomerPersonID() {
		return customerPersonID;
	}

	public void setCustomerPersonID(Customer customerPersonID) {
		this.customerPersonID = customerPersonID;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getCubic() {
		return cubic;
	}

	public void setCubic(int cubic) {
		this.cubic = cubic;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Set<DamageForm> getDmgForms() {
		return dmgForms;
	}

	public void setDmgForms(Set<DamageForm> dmgForms) {
		this.dmgForms = dmgForms;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", licensePlate=" + licensePlate + ", customerPersonID=" + customerPersonID
				+ ", releaseDate=" + releaseDate + ", cubic=" + cubic + ", type=" + type + ", color=" + color
				+ ", dmgForms=" + dmgForms + ", insurance=" + insurance + "]";
	}

}
