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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/*Link the class,fields with the database table,columns.Declare constraints and relations with other entities*/
@Entity
@Table(name = "User")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8711080328736274624L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long userId;

	@NotEmpty(message = "This field is required")
	@Size(max = 50)
	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;

	@NotEmpty(message = "This field is required")
	@Size(max = 50)
	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;

	@Email
	@Size(max = 50)
	@NotEmpty(message = "This field is required")
	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String emailAdress;

	@Size(max = 10)
	@Column(name = "phone", nullable = true)
	private String telephone;

	@ManyToOne
	@JoinColumn(name = "role_id", nullable = true)
	private Role assignedRole;

	@ManyToOne
	@JoinColumn(name = "department_id", nullable = true)
	private Department workingDept;

	@NotEmpty(message = "This field is required")
	@Size(max = 50)
	@Column(name = "username", length = 50, nullable = false, unique = true)
	private String userName;

	@NotEmpty(message = "This field is required")
	@Size(min = 6, max = 250)
	@Column(name = "password", length = 50, nullable = false)
	private String password;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
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