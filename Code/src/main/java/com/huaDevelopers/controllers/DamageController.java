package com.huaDevelopers.controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.huaDevelopers.data.Entities.DamageForm;
import com.huaDevelopers.data.Entities.Insurance;
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

	// submit the form for the declaration of the damage
	@RequestMapping(value = "/declare/{lp}", method = RequestMethod.GET)
	public String declareDamage(Model model, @PathVariable("lp") String lp) {
		model.addAttribute("lp", lp);
		model.addAttribute("dform", new DamageForm());
		return "dmg_declare";
	}

	// save form into db for possible retrieval from approval purposes
	@RequestMapping(value = "/declare/{lp}", method = RequestMethod.POST)
	public String saveDamage(@Valid @ModelAttribute("dform") DamageForm dform, Errors errors,
			@PathVariable("lp") String lp, @RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			errors.rejectValue("damagePhotoShoots", "DamageForm.damagePhotoShoots", "A file must be selected");
			return "dmg_declare";
		}
		if (!file.getContentType().equals("image/png") && !file.getContentType().equals("image/jpeg")
				&& !file.equals("image/jpg")) {
			errors.rejectValue("damagePhotoShoots", "DamageForm.damagePhotoShoots",
					"jpeg/jpg/png file types are only supported");
		}
		if (errors.hasErrors()) {
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
		return "redirect:/cms/damage/view";
	}

	@RequestMapping(value = "/view")
	public String find(Model model) {
		model.addAttribute("dmg_forms", this.dmgService.listAllDamageForms());
		return "dmg_all";
	}

	@RequestMapping(value = "/view/specific")
	public String findSpecific(Model model) {
		model.addAttribute("dmg_forms", this.dmgService.listAllDamageForms());
		return "dmg_specific";
	}

	// get the preview of the damage form thus for Sales Manager or CEO to
	// review and either approve or not
	@RequestMapping(value = "/{id:\\d+}/review", method = RequestMethod.GET)
	public String review(@PathVariable("id") int id, Model model, @ModelAttribute("dform") DamageForm dform) {
		dform = this.dmgService.getFormById(id);
		Vehicle dmgCar = dform.getLicensePlate();
		Insurance carInsur = dmgCar.getInsurance();
		model.addAttribute("insurance", carInsur);
		model.addAttribute("damage", dform);
		return "dmg_approval";
	}

	// helper method - managing the view of the image to the reviewer
	@RequestMapping(value = "/{id:\\d+}/imageDisplay", method = RequestMethod.GET)
	public void showImage(@PathVariable("id") int id, HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		DamageForm dform = this.dmgService.getFormById(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(dform.getDamagePhotoShoots());
		response.getOutputStream().close();
	}

	// make the approval of the form and update status of approval in the
	// database
	@RequestMapping(value = "/{id:\\d+}/approve", method = RequestMethod.GET)
	public String approve(@PathVariable("id") int id) {
		DamageForm dform = this.dmgService.getFormById(id);
		dform.setApproval(true);
		this.dmgService.updateDamageForm(dform);
		return "redirect:/cms/damage/view";
	}

	// same logic as above but for denial
	@RequestMapping(value = "/{id:\\d+}/deny", method = RequestMethod.GET)
	public String deny(@PathVariable("id") int id) {
		DamageForm dform = this.dmgService.getFormById(id);
		dform.setApproval(false);
		this.dmgService.updateDamageForm(dform);
		return "redirect:/cms/damage/view";
	}

	// counter function for showing in UI badge the remainder of the approvals
	// for each user role
	@RequestMapping(value = "/formCount/{role}")
	public @ResponseBody Long getFormCount(@PathVariable("role") String role) {
		return this.dmgService.getFormCount(role);
	}
}
