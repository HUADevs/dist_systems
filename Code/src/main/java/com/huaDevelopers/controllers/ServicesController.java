package com.huaDevelopers.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.huaDevelopers.data.Entities.Services;
import com.huaDevelopers.data.Services.Interfaces.ServEntityService;

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
		return "redirect:/admin/service/view";
	}
	
	@RequestMapping(value="/view", method= RequestMethod.GET)
	public String viewServices(Model model)
	{
		List<Services> services = this.s_service.listAllServices();
		model.addAttribute("services",services);
		return "service_all";
	}
	
	@RequestMapping(value="/delete/{serviceId}", method= RequestMethod.GET)
	public String DeleteService(@PathVariable("serviceId") int serviceId, Model model, RedirectAttributes redirectAttributes) {
		this.s_service.removeService(serviceId);;
		return "redirect:/admin/service/view";
	}

	@RequestMapping(value = "/edit/{serviceId}")
	public String UpdateService(@PathVariable("serviceId") int serviceId, Model model) {
		model.addAttribute("service",this.s_service.getServiceByID(serviceId));
		return "service_edit";
	}

	@RequestMapping(value = "/edit/{serviceId}", method = RequestMethod.POST)
	public String saveEditedUser(Model model, @PathVariable("serviceId") int serviceId,
			@Valid @ModelAttribute("service") Services service, Errors errors) {
		if (errors.hasErrors()) {
			return "service_edit";
		}
		this.s_service.updateService(service);

		return "redirect:/admin/service/view";
	}

}
