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
	@ManyToOne
	@JoinColumn(name = "license_plate", unique=true, nullable=false)
	private Vehicle licensePlate;

	@NotEmpty
	@Column(name = "description", nullable=false)
	private String damageDescription;

	@NotEmpty
	@Column(name = "photo", nullable=false)
	private byte[] damagePhotoShoots;

	@NotEmpty
	@Column(name = "cost", nullable=false)
	private float damageCost;

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

	public float getDamageCost() {
		return damageCost;
	}

	public void setDamageCost(float damageCost) {
		this.damageCost = damageCost;
	}

	public Boolean getApproval() {
		return approval;
	}

	public void setApproval(Boolean approval) {
		this.approval = approval;
	}

}
