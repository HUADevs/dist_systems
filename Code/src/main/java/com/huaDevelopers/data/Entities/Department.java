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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Department")
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1005970238302103520L;

	public Department() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private int id;

	@NotEmpty
	@Column(name = "name", unique = true, nullable = false)
	private String depName;

	@NotEmpty
	@Column(name = "region", nullable = false)
	private String location;

	@NotEmpty
	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "phone", nullable = false)
	private int phone;

	@Column(name = "num_of_emp", nullable = false)
	private int numEmp;

	@JsonIgnore
	@OneToMany(mappedBy = "workingDept")
	private Set<User> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getNumEmp() {
		return numEmp;
	}

	public void setNumEmp(int numEmp) {
		this.numEmp = numEmp;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
