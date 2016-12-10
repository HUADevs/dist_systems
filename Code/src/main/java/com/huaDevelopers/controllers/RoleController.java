package com.huaDevelopers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huaDevelopers.data.Services.RoleService;

@Controller
@RequestMapping("/cms/role")
public class RoleController {

	private RoleService roleService;

	@Autowired
	@Qualifier(value = "roleService")
	public void setCustomerService(RoleService roleService) {
		this.roleService = roleService;
	}

	public void addRole() {
	}

	public void saveRole() {
	}

	public void DeleteRole() {
		// TODO - implement RoleController.DeleteRole
		throw new UnsupportedOperationException();
	}

	public void UpdateCompetences() {
		// TODO - implement RoleController.UpdateCompetences
		throw new UnsupportedOperationException();
	}

}
