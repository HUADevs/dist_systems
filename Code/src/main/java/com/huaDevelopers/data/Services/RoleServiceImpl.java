package com.huaDevelopers.data.Services;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.huaDevelopers.dao.RoleDao;
import com.huaDevelopers.data.Entities.Role;
import com.huaDevelopers.data.Entities.Services;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleDao roleDAO;
	
	
	
	public void setRoleDAO(RoleDao roleDAO) {
		this.roleDAO = roleDAO;
	}

	@Override
	@Transactional
	public void addRole(Role role) {
		this.roleDAO.addRole(role);

	}

	@Override
	@Transactional
	public void updateRole(Role role) {
		this.roleDAO.updateRole(role);

	}

	@Override
	@Transactional
	public Role getRoleByID(int id) {
		return this.roleDAO.getRoleByID(id);
		
	}

	@Override
	@Transactional
	public List<Role> listAllRoles() {
		return this.roleDAO.listAllRoles();
	}

	@Override
	@Transactional
	public void removeRole(int id) {
		this.roleDAO.removeRole(id);

	}

	@Transactional
	@Override
	public Set<Services> listServices() {
		return this.roleDAO.listServices();
	}

	@Override
	public void setServices() {
		this.roleDAO.setServices();
	}

}
