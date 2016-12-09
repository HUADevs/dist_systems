package com.huaDevelopers.data.Entities;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {

	private String RoleName;
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
