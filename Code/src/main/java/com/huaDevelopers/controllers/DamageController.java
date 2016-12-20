package com.huaDevelopers.controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String saveDamage(@Valid @ModelAttribute("dform") DamageForm dform,Errors errors, @PathVariable("lp") String lp,@RequestParam("file") MultipartFile file) {
		if(file.isEmpty()){
			errors.rejectValue("damagePhotoShoots", "DamageForm.damagePhotoShoots", "A file must be selected");
			return "dmg_declare";
		}
		if(!file.getContentType().equals("image/png") || !file.getContentType().equals("image/jpeg") || !file.equals("image/jpg")){
			errors.rejectValue("damagePhotoShoots", "DamageForm.damagePhotoShoots", "jpg/png file types are only supported");
		}
		if(errors.hasErrors()){
			return "dmg_declare";
		}
		
		dform.setDateAdded(LocalDate.now());
		try {
			dform.setDamagePhotoShoots(file.getBytes());
		} catch (IOException e) {
			System.out.println("failed to upload file");
			e.printStackTrace();
		}
		Vehicle veh = this.vService.getVehicleByLP(lp);
		dform.setLicensePlate(this.vService.getVehicleByPID(veh.getId()));
		this.dmgService.addDamageForm(dform);
		return "dmg_declare";
	}

}
