package com.huaDevelopers.dao;

import java.util.List;
import java.util.Set;

import com.huaDevelopers.data.Entities.Role;
import com.huaDevelopers.data.Entities.Services;

public interface RoleDao {
	public void addRole(Role role);

	public void updateRole(Role role);

	public Role getRoleByID(int id);

	public List<Role> listAllRoles();

	public void removeRole(int id);
	
	public Set<Services> listServices();
	
	public void setServices();

}
