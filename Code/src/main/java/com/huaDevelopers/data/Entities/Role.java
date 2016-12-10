package com.huaDevelopers.data.Entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role implements Serializable {

	@Column(name = "name")
	private String RoleName;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int RoleId;
	
	private Set<Service> services;

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

	@ManyToMany
	@JoinTable(name = "Right", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
	public Set<Service> getServices() {
		return services;
	}
	
	public void setServices(Set<Service> services){
		this.services=services;
	}

}
