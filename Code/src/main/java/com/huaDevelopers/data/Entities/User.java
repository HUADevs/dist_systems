package com.huaDevelopers.data.Entities;

import java.io.Serializable;

public class User implements Serializable {

	private int Userid;
	private String FirstName;
	private String LastName;
	private String EmailAdress;
	private int Telephone;
	private Role AssignedRole;
	private Department WorkingDept;
	private String UserName;
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

	public Role getAssignedRole() {
		return this.AssignedRole;
	}

	public void setAssignedRole(Role AssignedRole) {
		this.AssignedRole = AssignedRole;
	}

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
