package com.huaDevelopers.data.Entities;

import java.io.Serializable;

public class Right implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2439852265201138223L;
	private int ServiceId;
	private int RoleId;
	private int RightId;

	public Right() {
		// TODO Auto-generated constructor stub
	}

	public int getServiceId() {
		return ServiceId;
	}

	public void setServiceId(int serviceId) {
		ServiceId = serviceId;
	}

	public int getRoleId() {
		return RoleId;
	}

	public void setRoleId(int roleId) {
		RoleId = roleId;
	}

	public int getRightId() {
		return RightId;
	}

	public void setRightId(int rightId) {
		RightId = rightId;
	}

}
