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
	
	@NotEmpty
	@Column(name="first_name", nullable=false)	
	private String FirstName;
	
	@NotEmpty
	@Column(name="last_name", nullable=false)
	private String LastName;

	@NotEmpty
	@Column(name="email", nullable=false)
	private String EmailAdress;
	
	@Column(name="phone", nullable=true)
	private int Telephone;
	
	@Column(name="role", nullable=true)
	private Role AssignedRole;
	
	@Column(name="department", nullable=true)
	private Department WorkingDept;
	
	@NotEmpty
	@Column(name="username", nullable=false)
	private String UserName;
	
	@NotEmpty
	@Column(name="password", nullable=false)
	private String Password;

	public int getUserid() {
		return Userid;
	}

	public void setUserid(int userid) {
		Userid = userid;
	}

	public String getName() {
		return this.FirstName + " " + this.LastName;
	}

	public void setName(String FirstName, String LastName) {
		this.FirstName = FirstName;
	}

	public String getEmailAddress() {
		return this.EmailAdress;
	}

	public void setEmailAdress(String EmailAdress) {
		this.EmailAdress = EmailAdress;
	}

	public int getPhoneNumber() {
		return this.Telephone;
	}

	public void setPhoneNumber(int Telephone) {
		this.Telephone = Telephone;
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
