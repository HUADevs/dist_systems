package com.huaDevelopers.data.Entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

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

	@NotEmpty
	@Column(name = "name", unique=true, nullable=false)
	private String DepName;

	@NotEmpty
	@Column(name = "region", nullable=false)
	private String Location;

	@NotEmpty
	@Column(name = "address", nullable=false)
	private String Address;

	@NotEmpty
	@Column(name = "num_of_emp", nullable=false)
	private int NumEmp;

	@OneToMany(mappedBy="WorkingDept")
	private Set<User> users;
	
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
