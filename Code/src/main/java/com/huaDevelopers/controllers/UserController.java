package com.huaDevelopers.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huaDevelopers.data.Entities.Department;
import com.huaDevelopers.data.Entities.Role;
import com.huaDevelopers.data.Entities.User;
import com.huaDevelopers.data.Services.DepartmentService;
import com.huaDevelopers.data.Services.RoleService;
import com.huaDevelopers.data.Services.UserService;

@Controller
@RequestMapping("/admin/user")
public class UserController {

	private UserService userService;

	private RoleService roleService;

	private DepartmentService deptService;

	@Autowired
	@Qualifier(value = "UserService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	@Qualifier(value = "roleService")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Autowired
	@Qualifier(value = "deptService")
	public void setDeptService(DepartmentService deptService) {
		this.deptService = deptService;
	}

	@RequestMapping(value = "/{UserName}")
	public String findUser(Model model, @PathVariable("UserName") String UserName) {
		model.addAttribute("user", this.userService.getUserByUsername(UserName));
		return "user";
	}

	@RequestMapping(value = "/find")
	public String find(Model model) {
		model.addAttribute("users", this.userService.listAllUser());
		return "users";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser(Model model) {
		List<Role> roles = roleService.listAllRoles();
		List<String> roleNames = new ArrayList<>();
		for (Role r : roles) {
			roleNames.add(r.getRoleName());
		}
		List<Department> departments = deptService.getAllDepts();
		List<String> deptNames = new ArrayList<>();
		deptNames.add("");
		for (Department d : departments) {
			deptNames.add(d.getDepName());
		}
		model.addAttribute("roles", roleNames);
		model.addAttribute("departments", deptNames);
		model.addAttribute("user", new User());
		return "user_add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("user") User user, Errors errors) {
		if (errors.hasErrors()) {
			return "user_add";
		}
		this.userService.addUser(user);

		return "test";

	}

	public void DeleteUser() {
		// TODO - implement UserController.DeleteUser
		throw new UnsupportedOperationException();
	}

	public void UpdateUserInfo() {
		// TODO - implement UserController.UpdateUserInfo
		throw new UnsupportedOperationException();
	}

}
