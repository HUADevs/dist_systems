package com.huaDevelopers.data.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Column(name = "license_plate")
	private String LicensePlate;

	@Column(name = "description")
	private String DamageDescription;

	@Column(name = "photo")
	private byte[] DamagePhotoShoots;

	@Column(name = "cost")
	private float DamageCost;

	@Column(name = "approval")
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

	public String getLicensePlate() {
		return LicensePlate;
	}

	public void setLicensePlate(String licensePlate) {
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
