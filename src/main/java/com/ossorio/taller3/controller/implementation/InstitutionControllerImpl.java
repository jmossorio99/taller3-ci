package com.ossorio.taller3.controller.implementation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ossorio.taller3.model.UsvInstitution;
import com.ossorio.taller3.service.interfaces.UsvInstitutionService;

@Controller
public class InstitutionControllerImpl {

	private final UsvInstitutionService usvInstitutionService;

	public InstitutionControllerImpl(UsvInstitutionService usvInstitutionService) {
		this.usvInstitutionService = usvInstitutionService;
	}

	@GetMapping("/institution")
	public String indexInstitution(Model model) {
		model.addAttribute("institutions", usvInstitutionService.findAll());
		return "institution/index";
	}

	@GetMapping("/institution/add")
	public String addInstitution(Model model) {
		model.addAttribute("usvInstitution", new UsvInstitution());
		return "institution/add-institution";
	}

	@PostMapping("/institution/add")
	public String saveInstitution(@RequestParam(value = "action", required = true) String action,
			@Validated @ModelAttribute UsvInstitution institution, BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				return "institution/add-institution";
			}
			usvInstitutionService.save(institution);
		}
		return "redirect:/institution/";
	}

	@GetMapping("/institution/edit/{id}")
	public String editInstitution(@PathVariable("id") long id, Model model) {
		model.addAttribute("usvInstitution", usvInstitutionService.findById(id));
		return "institution/edit-institution";
	}

	@PostMapping("/institution/edit/{id}")
	public String editInstitutionPost(@RequestParam(value = "action", required = true) String action,
			@PathVariable("id") long id, @Validated @ModelAttribute UsvInstitution institution,
			BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				return "institution/edit/{id}";
			}
			institution.setInstId(id);
			usvInstitutionService.update(institution);
		}
		return "redirect:/institution/";
	}

}
