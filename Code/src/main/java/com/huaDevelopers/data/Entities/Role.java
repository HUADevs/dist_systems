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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Role")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2277203042640497446L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int RoleId;

	@NotEmpty
	@Column(name = "name", nullable=false)
	private String RoleName;

	private Set<Services> services;

	private Set<User> users;
	
	public int getRoleId() {
		return RoleId;
	}

	public void setRoleId(int roleId) {
		RoleId = roleId;
	}

	String getRoleName() {
		return this.RoleName;
	}

	public void setRoleName(String RoleName) {
		this.RoleName = RoleName;
	}

	@ManyToMany
	@JoinTable(name = "Right", 
		joinColumns = @JoinColumn(name = "role_id"),
		inverseJoinColumns = @JoinColumn(name = "service_id"))
	public Set<Services> getServices() {
		return services;
	}

	public void setServices(Set<Services> services) {
		this.services = services;
	}

	@OneToMany(mappedBy="AssignedRole")
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
