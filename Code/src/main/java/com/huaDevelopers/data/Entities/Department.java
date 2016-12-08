package com.huaDevelopers.data.Entities;

import java.io.Serializable;

public class Department implements Serializable {

	public Department() {
		// TODO Auto-generated constructor stub
	}

	private int id;
	private String DepName;
	private String Location;
	private String Address;
	private int NumEmp;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepName() {
		return DepName;
	}

	public void setDepName(String depName) {
		DepName = depName;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getNumEmp() {
		return NumEmp;
	}

	public void setNumEmp(int numEmp) {
		NumEmp = numEmp;
	}

}
