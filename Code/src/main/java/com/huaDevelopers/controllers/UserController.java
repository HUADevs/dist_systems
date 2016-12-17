package com.huaDevelopers.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.huaDevelopers.data.Entities.User;
import com.huaDevelopers.data.Services.Interfaces.DepartmentService;
import com.huaDevelopers.data.Services.Interfaces.RoleService;
import com.huaDevelopers.data.Services.Interfaces.UserService;

@Controller
@RequestMapping("/admin/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private DepartmentService deptService;

	@RequestMapping(value = "/view")
	public String find(Model model) {
		model.addAttribute("users", this.userService.listAllUser());
		return "user_all";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser(Model model) {
		model.addAttribute("roles", this.roleService.listAllRoles());
		model.addAttribute("departments", this.deptService.getAllDepts());
		model.addAttribute("user", new User());
		return "user_add";
	}

	// Form to add new user
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveUser(Model model, @Valid @ModelAttribute("user") User user, Errors errors) {
		if (!user.getEmailAdress().isEmpty()) {
			if (this.userService.getUserByEmail(user.getEmailAdress()) != null) {
				errors.rejectValue("emailAdress", "user.emailAdress", "This email is already in use.");
				model.addAttribute("roles", this.roleService.listAllRoles());
				model.addAttribute("departments", this.deptService.getAllDepts());
				return "user_add";
			} 
		}
		if (!user.getUserName().isEmpty()) {
			if (this.userService.getUserByUsername(user.getUserName()) != null) {
				errors.rejectValue("userName", "user.userName", "This username is already in use.");
				model.addAttribute("roles", this.roleService.listAllRoles());
				model.addAttribute("departments", this.deptService.getAllDepts());
				return "user_add";
			} 
		}
		if (errors.hasErrors()) {
			model.addAttribute("roles", this.roleService.listAllRoles());
			model.addAttribute("departments", this.deptService.getAllDepts());
			return "user_add";
		} else {

			user.setAssignedRole(this.roleService.getRoleByID(user.getAssignedRole().getRoleId()));
			if (user.getWorkingDept() != null)
				user.setWorkingDept(this.deptService.getDeptByID(user.getWorkingDept().getId()));
			this.userService.addUser(user);
		}

		return "redirect:/admin/user/view";
	}

	// form to edit user by his id
	@RequestMapping(value = "/edit/{userId}")
	public String UpdateUserInfo(@PathVariable("userId") int userId, Model model) {
		model.addAttribute("roles", this.roleService.listAllRoles());
		model.addAttribute("departments", this.deptService.getAllDepts());
		model.addAttribute("user", this.userService.getUserById(userId));
		return "user_edit";
	}

	@RequestMapping(value = "/edit/{userId}", method = RequestMethod.POST)
	public String saveEditedUser(Model model, @PathVariable("userId") int userId,
			@Valid @ModelAttribute("user") User user, Errors errors) {
		if (this.userService.getUserByEmail(user.getEmailAdress()) != null
				&& !(this.userService.getUserById(user.getUserId()).getEmailAdress().equals(user.getEmailAdress()))) {
			errors.rejectValue("emailAdress", "user.emailAdress", "This email is already in use.");
			model.addAttribute("roles", this.roleService.listAllRoles());
			model.addAttribute("departments", this.deptService.getAllDepts());
			return "user_edit";
		}
		if (this.userService.getUserByUsername(user.getUserName()) != null
				&& !(this.userService.getUserById(user.getUserId()).getUserName().equals(user.getUserName()))) {
			errors.rejectValue("userName", "user.userName", "This username is already in use.");
			model.addAttribute("roles", this.roleService.listAllRoles());
			model.addAttribute("departments", this.deptService.getAllDepts());
			return "user_edit";
		}
		if (errors.hasErrors()) {
			model.addAttribute("roles", this.roleService.listAllRoles());
			model.addAttribute("departments", this.deptService.getAllDepts());
			return "user_edit";
		} else {
			// set existing role and department from the database
			user.setAssignedRole(this.roleService.getRoleByID(user.getAssignedRole().getRoleId()));
			if (user.getWorkingDept() != null)
				user.setWorkingDept(this.deptService.getDeptByID(user.getWorkingDept().getId()));
			this.userService.updateUser(user);
		}
		return "redirect:/admin/user/view";
	}

	// delete a user by his id
	@RequestMapping(value = "/delete/{userId}")
	public String DeleteUser(@PathVariable("userId") int userId, Model model, RedirectAttributes redirectAttributes) {
		this.userService.removeUser(userId);
		return "redirect:/admin/user/view";
	}

}
