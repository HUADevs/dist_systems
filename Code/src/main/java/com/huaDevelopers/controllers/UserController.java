package com.huaDevelopers.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
import com.huaDevelopers.data.Validators.UserValidator;

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

	// Form to add new user
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveUser(Model model, @Valid @ModelAttribute("user") User user, Errors errors) {
		if (errors.hasErrors()) {
			List<Role> roles = roleService.listAllRoles();
			List<Department> departments = deptService.getAllDepts();
			model.addAttribute("roles", roles);
			model.addAttribute("departments", departments);
			return "user_add";
		}

		// try {
		user.setAssignedRole(this.roleService.getRoleByID(user.getAssignedRole().getRoleId()));
		if (user.getWorkingDept() != null)
			user.setWorkingDept(this.deptService.getDeptByID(user.getWorkingDept().getId()));
		this.userService.addUser(user);
		// } catch (ConstraintViolationException e) {
		// System.out.println(e.getConstraintName());
		// model.addAttribute("validationErrors", e.getConstraintName());
		// return "user_add";
		// }

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
		List<Role> roles = roleService.listAllRoles();
		List<Department> departments = deptService.getAllDepts();
		model.addAttribute("roles", roles);
		model.addAttribute("departments", departments);
		model.addAttribute("user", this.userService.getUserById(userId));
		return "user_edit";
	}

	@RequestMapping(value = "/{userId}/edit", method = RequestMethod.POST)
	public String saveEditedUser(Model model, @PathVariable("userId") int userId,
			@Valid @ModelAttribute("user") User user, Errors errors) {
		if (errors.hasErrors()) {
			List<Role> roles = roleService.listAllRoles();
			List<Department> departments = deptService.getAllDepts();
			model.addAttribute("roles", roles);
			model.addAttribute("departments", departments);
			return "user_edit";
		}
		// set existing role and department from the database
		user.setAssignedRole(this.roleService.getRoleByID(user.getAssignedRole().getRoleId()));
		if (user.getWorkingDept() != null)
			user.setWorkingDept(this.deptService.getDeptByID(user.getWorkingDept().getId()));
		this.userService.updateUser(user);

		return "redirect:/admin/user/find";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UserValidator());
	}

}
