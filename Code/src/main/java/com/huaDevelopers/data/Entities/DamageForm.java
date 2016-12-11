package com.huaDevelopers.data.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "DamageForm")
public class DamageForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8281914402815923421L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotEmpty
	@Column(name = "license_plate", length=7, unique=true, nullable=false)
	private Vehicle LicensePlate;

	@NotEmpty
	@Column(name = "description", nullable=false)
	private String DamageDescription;

	@NotEmpty
	@Column(name = "photo", nullable=false)
	private byte[] DamagePhotoShoots;

	@NotEmpty
	@Column(name = "cost", nullable=false)
	private float DamageCost;

	@Column(name = "approval", nullable=true)
	private Boolean approval;

	public DamageForm() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="license_plate", nullable=false)
	public Vehicle getLicensePlate() {
		return LicensePlate;
	}

	public void setLicensePlate(Vehicle licensePlate) {
		LicensePlate = licensePlate;
	}

	public String getDamageDescription() {
		return DamageDescription;
	}

	public void setDamageDescription(String damageDescription) {
		DamageDescription = damageDescription;
	}

	public byte[] getDamagePhotoShoots() {
		return DamagePhotoShoots;
	}

	public void setDamagePhotoShoots(byte[] damagePhotoShoots) {
		DamagePhotoShoots = damagePhotoShoots;
	}

	public float getDamageCost() {
		return DamageCost;
	}

	public void setDamageCost(float damageCost) {
		DamageCost = damageCost;
	}

	public Boolean getApproval() {
		return approval;
	}

	public void setApproval(Boolean approval) {
		this.approval = approval;
	}

}
