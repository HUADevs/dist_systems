package com.huaDevelopers.data.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2277203042640497446L;

	@Column(name="name")
	private String RoleName;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int RoleId;

	public String getRoleName() {
		return this.RoleName;
	}

	public void setRoleName(String RoleName) {
		this.RoleName = RoleName;
	}

	public int getRoleId() {
		return RoleId;
	}

	public void setRoleId(int roleId) {
		RoleId = roleId;
	}

}
