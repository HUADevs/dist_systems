package com.huaDevelopers.data.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1274403189847335127L;

	public Department() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String DepName;

	@Column(name = "region")
	private String Location;

	@Column(name = "address")
	private String Address;

	@Column(name = "num_of_emp")
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
