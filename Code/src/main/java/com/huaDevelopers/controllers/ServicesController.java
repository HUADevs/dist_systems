package com.huaDevelopers.controllers;







import java.beans.PropertyEditorSupport;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huaDevelopers.data.Entities.Role;
import com.huaDevelopers.data.Entities.Services;
import com.huaDevelopers.data.Services.RoleService;
import com.huaDevelopers.data.Services.ServEntityService;

@Controller
@RequestMapping("/admin/service")
public class ServicesController {

	private ServEntityService s_service;
	private RoleService r_service;
	
	@Autowired
	@Qualifier(value = "ServEntityService")
	public void setServEntityService (ServEntityService s_service){
		this.s_service=s_service;
	}
	
	@Autowired
	@Qualifier(value = "roleService")
	public void setRoleService (RoleService r_service){
		this.r_service=r_service;
	}
	
	public class RolePropertyEditor extends PropertyEditorSupport {

	    private Map<String, Role> roleMap = new HashMap<String, Role>();

	    public RolePropertyEditor(List<Role> roleList) {
	        for (Role r : roleList) roleMap.put(r.getRoleName(), r);
	    }

	    public void setAsText(String incomingId) {
	        Role role = roleMap.get(incomingId);
	        System.out.println("PROPERTY EDITOR ROLE " + role);
	        setValue(role);
	    }

	    public String getAsText() {
	        System.out.println("PROPERTY EDITOR ID " + ((Role)getValue()).getRoleId());
	        return String.valueOf(((Role)getValue()).getRoleId());
	    }
	}
	 
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Role.class, new RolePropertyEditor(this.r_service.listAllRoles()));
	}
	
	@RequestMapping(value="/add" , method = RequestMethod.GET)
	public String addService(Model model) {
		List<Role> roles = this.r_service.listAllRoles();
		model.addAttribute("rolesatr" , roles);
		model.addAttribute("service", new Services());
	
		return "add_service";
	}
	
	@RequestMapping(value="/add" , method= RequestMethod.POST)
	public String saveService(Model model,@Valid @ModelAttribute("service") Services serv, Errors error , BindingResult results){
		if (error.hasErrors()){
			List<Role> roles = this.r_service.listAllRoles();
			model.addAttribute("rolesatr" , roles);
			System.out.println("error");
			return "add_service";	
		}
		
		for(Role r:serv.getRoles()){
			System.out.println(r.getRoleName());
		}
		System.out.println("test");
		return "redirect:/admin/service/add";
	}
	
	public void RemoveService() {
		// TODO - implement ServicesController.RemoveService
		throw new UnsupportedOperationException();
	}

	public void UpdateRights() {
		// TODO - implement ServicesController.UpdateRights
		throw new UnsupportedOperationException();
	}

}
