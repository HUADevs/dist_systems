package com.huaDevelopers.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private DepartmentService deptService;

	@RequestMapping(value = "/find")
	public String find(Model model) {
		model.addAttribute("users", this.userService.listAllUser());
		return "users";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser(Model model) {
		List<Role> roles = roleService.listAllRoles();
		List<Department> departments = deptService.getAllDepts();
		model.addAttribute("roles", roles);
		model.addAttribute("departments", departments);
		model.addAttribute("user", new User());
		return "user_add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveUser(Model model,@Valid @ModelAttribute("user") User user, Errors errors) {
		if (errors.hasErrors()) {
			List<Role> roles = roleService.listAllRoles();
			List<Department> departments = deptService.getAllDepts();
			model.addAttribute("roles", roles);
			model.addAttribute("departments", departments);
			return "user_add";
		}
		if(user.getUserId() == 0){
			//new person, add it
			this.userService.addUser(user);
		}else{
			//existing person, call update
			this.userService.updateUser(user);
		}

		return "redirect:/admin/user/find";
	}

	public void DeleteUser() {
		// TODO - implement UserController.DeleteUser
		throw new UnsupportedOperationException();
	}

	@RequestMapping(value = "/{UserName}/edit")
	public void UpdateUserInfo() {
		// TODO - implement UserController.UpdateUserInfo
		throw new UnsupportedOperationException();
	}

}
