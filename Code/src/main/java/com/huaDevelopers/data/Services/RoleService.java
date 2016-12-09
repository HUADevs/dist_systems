package com.huaDevelopers.data.Services;

import java.util.List;

import com.huaDevelopers.data.Entities.Role;

public interface RoleService {

	public void addRole(Role role);

	public void updateRole(Role role);

	public Role getRoleByID(int id);

	public List<Role> listAllRoles();

	public void removeRole(int id);
}
