package com.huaDevelopers.data.Entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "DamageForm")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DamageForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8281914402815923421L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "vehicle_id", nullable = false)
	private Vehicle licensePlate;

	@NotBlank(message = "**You must provide a description of the damage**")
	@Column(name = "description", length = 100, nullable = false)
	private String damageDescription;

	//Lob annotation and byte array for saving and retrieving image objects from database
	@Lob
	@Column(name = "photo", nullable = false)
	private byte[] damagePhotoShoots;

	@DecimalMax(value = "99999.999", message = "The decimal value can not be more than 99999.999 ")
	@DecimalMin(value = "1.00", message = "The decimal value can not be less than 1.00 ")
	@Column(name = "cost", nullable = false)
	private double damageCost;

	@Column(name = "approval", nullable = true)
	private Boolean approval;

	@Column(name = "date", nullable = false)
	private LocalDate dateAdded;

	public DamageForm() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vehicle getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(Vehicle licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getDamageDescription() {
		return damageDescription;
	}

	public void setDamageDescription(String damageDescription) {
		this.damageDescription = damageDescription;
	}

	public byte[] getDamagePhotoShoots() {
		return damagePhotoShoots;
	}

	public void setDamagePhotoShoots(byte[] damagePhotoShoots) {
		this.damagePhotoShoots = damagePhotoShoots;
	}

	public double getDamageCost() {
		return damageCost;
	}

	public void setDamageCost(double damageCost) {
		this.damageCost = damageCost;
	}

	public Boolean getApproval() {
		return approval;
	}

	public void setApproval(Boolean approval) {
		this.approval = approval;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}

}
