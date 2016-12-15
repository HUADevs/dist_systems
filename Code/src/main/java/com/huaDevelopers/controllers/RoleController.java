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
			System.out.println("error");
			return "role_add";	
		}
		
		for(Services s:role.getServices()){
			System.out.println(s.getServiceName());
		}
		System.out.println("test");
		return "redirect:/admin/role/add";
	}
}
