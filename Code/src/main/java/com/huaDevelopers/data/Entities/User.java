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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="User")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8711080328736274624L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int userId;
	
	@NotEmpty(message="This field is required")
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@NotEmpty(message="This field is required")
	@Column(name="last_name", nullable=false)
	private String lastName;

	@Email
	@NotEmpty(message="This field is required")
	@Column(name="email", nullable=false,unique=true)
	private String emailAdress;
	
	@Column(name="phone", nullable=true)
	private String telephone;
	
	@ManyToOne
	@JoinColumn(name="role_id", nullable=false)
	private Role assignedRole;
	
	@ManyToOne
	@JoinColumn(name="department_id", nullable=true)
	private Department workingDept;
	
	@NotEmpty(message="This field is required")
	@Column(name="username", nullable=false,unique=true)
	private String userName;
	
	@NotEmpty(message="This field is required")
	@Column(name="password", nullable=false)
	private String password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Role getAssignedRole() {
		return assignedRole;
	}

	public void setAssignedRole(Role assignedRole) {
		this.assignedRole = assignedRole;
	}

	public Department getWorkingDept() {
		return workingDept;
	}

	public void setWorkingDept(Department workingDept) {
		this.workingDept = workingDept;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
