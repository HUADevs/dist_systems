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
@Table(name="User")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4377313444247498605L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int Userid;
	
	@NotEmpty(message="This field is required")
	@Column(name="first_name", nullable=false)	
	private String FirstName;
	
	@NotEmpty(message="This field is required")
	@Column(name="last_name", nullable=false)
	private String LastName;

	@NotEmpty(message="This field is required")
	@Column(name="email", nullable=false)
	private String EmailAdress;
	
	@Column(name="phone", nullable=true)
	private String Telephone;
	
	@Column(name="role", nullable=true)
	private Role AssignedRole;
	
	@Column(name="department", nullable=true)
	private Department WorkingDept;
	
	@NotEmpty(message="This field is required")
	@Column(name="username", nullable=false)
	private String UserName;
	
	@NotEmpty(message="This field is required")
	@Column(name="password", nullable=false)
	private String Password;

	public int getUserid() {
		return Userid;
	}

	public void setUserid(int userid) {
		Userid = userid;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String telephone) {
		Telephone = telephone;
	}

	public String getEmailAdress() {
		return EmailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		EmailAdress = emailAdress;
	}

	@ManyToOne
	@JoinColumn(name="role_id", nullable=false)
	public Role getAssignedRole() {
		return this.AssignedRole;
	}

	public void setAssignedRole(Role AssignedRole) {
		this.AssignedRole = AssignedRole;
	}

	@ManyToOne
	@JoinColumn(name="department", nullable=true)
	public Department getWorkingDept() {
		return this.WorkingDept;
	}

	public void setWorkingDept(Department WorkingDept) {
		this.WorkingDept = WorkingDept;
	}

	public String getUserName() {
		return this.UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}

	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}
}
