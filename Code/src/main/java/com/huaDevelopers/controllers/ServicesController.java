package com.huaDevelopers.controllers;







import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huaDevelopers.data.Entities.Services;
import com.huaDevelopers.data.Services.ServEntityService;

@Controller
@RequestMapping("/admin/service")
public class ServicesController {

	private ServEntityService s_service;
	
	@Autowired
	@Qualifier(value = "ServEntityService")
	public void setServEntityService (ServEntityService s_service){
		this.s_service=s_service;
	}
	

	@RequestMapping(value="/add" , method = RequestMethod.GET)
	public String addService(Model model) {
		model.addAttribute("service", new Services());
		return "service_add";
	}
	
	@RequestMapping(value="/add" , method= RequestMethod.POST)
	public String saveService(Model model,@Valid @ModelAttribute("service") Services serv, Errors error , BindingResult results){
		if (error.hasErrors()){
			System.out.println("error");
			return "service_add";	
		}
		this.s_service.addService(serv);
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
