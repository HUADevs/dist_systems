package com.huaDevelopers.controllers;

import java.util.List;

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

import com.huaDevelopers.data.Entities.Department;
import com.huaDevelopers.data.Entities.Role;
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

	@RequestMapping(value = "/find")
	public String find(Model model) {
		model.addAttribute("users", this.userService.listAllUser());
		return "users";
	}

	@ModelAttribute("roles")
	public List<Role> getRoles() {
		return roleService.listAllRoles();
	}

	@ModelAttribute("departments")
	public List<Department> getDepts() {
		return deptService.getAllDepts();
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "user_add";
	}

	// Form to add new user
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveUser(Model model, @Valid @ModelAttribute("user") User user, Errors errors) {
		if (this.userService.getUserByEmail(user.getEmailAdress()) != null) {
			errors.rejectValue("emailAdress", "user.emailAdress", "This email is already in use.");
			return "user_add";
		}
		if (this.userService.getUserByUsername(user.getUserName()) != null) {
			errors.rejectValue("userName", "user.userName", "This username is already in use.");
			return "user_add";
		}
		if (errors.hasErrors()) {
			return "user_add";
		} else {

			user.setAssignedRole(this.roleService.getRoleByID(user.getAssignedRole().getRoleId()));
			if (user.getWorkingDept() != null)
				user.setWorkingDept(this.deptService.getDeptByID(user.getWorkingDept().getId()));
			this.userService.addUser(user);
		}

		return "redirect:/admin/user/find";
	}

	// delete a user by his id
	@RequestMapping(value = "/{userId}/delete")
	public String DeleteUser(@PathVariable("userId") int userId, Model model, RedirectAttributes redirectAttributes) {
		this.userService.removeUser(userId);
		model.addAttribute("msg", "There is no user with that id in the database");
		return "redirect:/admin/user/find";
	}

	// form to edit user by his id
	@RequestMapping(value = "/{userId}/edit")
	public String UpdateUserInfo(@PathVariable("userId") int userId, Model model) {
		model.addAttribute("user", this.userService.getUserById(userId));
		return "user_edit";
	}

	@RequestMapping(value = "/{userId}/edit", method = RequestMethod.POST)
	public String saveEditedUser(Model model, @PathVariable("userId") int userId,
			@Valid @ModelAttribute("user") User user, Errors errors) {
		if (this.userService.getUserByEmail(user.getEmailAdress()) != null
				&& !(this.userService.getUserById(user.getUserId()).getEmailAdress().equals(user.getEmailAdress()))) {
			errors.rejectValue("emailAdress", "user.emailAdress", "This email is already in use.");
			return "user_edit";
		}
		if (this.userService.getUserByUsername(user.getUserName()) != null
				&& !(this.userService.getUserById(user.getUserId()).getUserName().equals(user.getUserName()))) {
			errors.rejectValue("userName", "user.userName", "This username is already in use.");
			return "user_edit";
		}
		if (errors.hasErrors()) {
			return "user_edit";
		} else {
			// set existing role and department from the database
			user.setAssignedRole(this.roleService.getRoleByID(user.getAssignedRole().getRoleId()));
			if (user.getWorkingDept() != null)
				user.setWorkingDept(this.deptService.getDeptByID(user.getWorkingDept().getId()));
			this.userService.updateUser(user);
		}
		return "redirect:/admin/user/find";
	}

	// @InitBinder
	// public void initBinder(WebDataBinder binder) {
	// binder.addValidators(new UserValidator());
	// }

}
