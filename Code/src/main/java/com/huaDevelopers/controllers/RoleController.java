package com.huaDevelopers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huaDevelopers.data.Entities.Role;
import com.huaDevelopers.data.Services.RoleService;

@Controller
@RequestMapping("/cms/role")
public class RoleController {

	private RoleService roleService;

	@Autowired
	@Qualifier(value = "roleService")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addRole(Model model) {
		model.addAttribute("role", new Role());
		return "role_add";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String saveRole(@ModelAttribute("role") Role role ) {
		if(role.getRoleId()== 0){
			this.roleService.addRole(role);
		}else{
			return "role_add";
		}
		
		return "test";
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
