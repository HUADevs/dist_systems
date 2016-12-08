package com.huaDevelopers.data.Entities;

import java.io.Serializable;

public class DamageForm implements Serializable{

	private int id;
	private String LicensePlate;
	private String DamageDescription;
	private byte[] DamagePhotoShoots;
	private float DamageCost;
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
