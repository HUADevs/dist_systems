package com.huaDevelopers.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huaDevelopers.data.Entities.DamageForm;
import com.huaDevelopers.data.Entities.Vehicle;
import com.huaDevelopers.data.Services.Interfaces.DamFormService;
import com.huaDevelopers.data.Services.Interfaces.VehicleService;

@Controller
@RequestMapping("/cms/damage")
public class DamageController {
	
	@Autowired
	private DamFormService dmgService;
	
	@Autowired
	private VehicleService vService;

	@RequestMapping(value="/declare/{lp}", method=RequestMethod.GET)
	public String declareDamage(Model model, @PathVariable("lp") String lp) {
		model.addAttribute("lp", lp);
		model.addAttribute("dform",new DamageForm());
		return "dmg_declare";
	}
	
	@RequestMapping(value="/declare/{lp}", method=RequestMethod.POST)
	public String saveDamage(@Valid @ModelAttribute("dform") DamageForm dform, @PathVariable("lp") String lp) {
		Vehicle veh = this.vService.getVehicleByLP(lp);
		dform.setLicensePlate(veh);
		this.dmgService.addDamageForm(dform);
		return "dmg_declare";
	}

}
