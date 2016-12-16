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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huaDevelopers.data.Entities.Role;
import com.huaDevelopers.data.Entities.Services;
import com.huaDevelopers.data.Services.Interfaces.RoleService;
import com.huaDevelopers.data.Services.Interfaces.ServEntityService;

@Controller
@RequestMapping("/admin/role")
public class RoleController {

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
	
	public class ServicePropertyEditor extends PropertyEditorSupport {

	    private Map<String, Services> servMap = new HashMap<String, Services>();

	    public ServicePropertyEditor(List<Services> servList) {
	        for (Services s : servList) servMap.put(s.getServiceName(),s);
	    }

	    public void setAsText(String incomingId) {
	        Services s = servMap.get(incomingId);
	        System.out.println("PROPERTY EDITOR SERVICE " + s);
	        setValue(s);
	    }

	    public String getAsText() {
	        System.out.println("PROPERTY EDITOR ID " + ((Services)getValue()).getServiceId());
	        return String.valueOf(((Services)getValue()).getServiceId());
	    }
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Services.class, new ServicePropertyEditor(this.s_service.listAllServices()));
	}
	
	@RequestMapping(value="/add" , method = RequestMethod.GET)
	public String addRole(Model model) {
		List<Services> services = this.s_service.listAllServices();
		model.addAttribute("allservices" , services);
		model.addAttribute("role", new Role());
		return "role_add";
	}
	
	@RequestMapping(value="/add" , method= RequestMethod.POST)
	public String saveRole(Model model,@Valid @ModelAttribute("role") Role role, Errors error , BindingResult results){
		if (error.hasErrors()){
			List<Services> allservices = this.s_service.listAllServices();
			model.addAttribute("allservices" , allservices);
			return "role_add";	
		}
		this.r_service.addRole(role);
		return "redirect:/admin/role/add";
	}
	
	@RequestMapping(value="/view", method= RequestMethod.GET)
	public String viewAllRoles(Model model){
		List<Role> roles = this.r_service.listAllRoles();
		model.addAttribute("roles", roles);
		return "role_all";
	}
	
	 @RequestMapping(value = { "/edit/{roleId}" }, method = RequestMethod.GET)
	    public String editRole(@PathVariable("roleId") int roleId, Model model) {
	       	List<Services> listservices = this.s_service.listAllServices();
	       	model.addAttribute("listservices", listservices);
	        model.addAttribute("role", 	this.r_service.getRoleByID(roleId));
	        return "role_edit";
	    }
	 
	 @RequestMapping(value = { "/edit/{roleId}" }, method = RequestMethod.POST)
	    public String updateUser(@Valid @ModelAttribute("role") Role role, BindingResult result,
	            Model model, @PathVariable("roleId") int roleId) {
	 
	        if (result.hasErrors()) {
	            return "role_edit";
	        }
	        
	        this.r_service.updateRole(role);
	        
	        return "redirect:/admin/role/view";
	    }
	
	@RequestMapping(value={"/delete/{roleId}"}, method= RequestMethod.GET)
	public String deleteRole(@PathVariable int roleId){
		this.r_service.removeRole(roleId);
		return "redirect:/admin/role/view";
	}
	
	
}
