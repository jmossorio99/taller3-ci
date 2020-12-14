package com.ossorio.barrera.taller4.controller.implementation;

import com.ossorio.barrera.taller4.delegate.interfaces.UsvInstitutionDelegate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ossorio.barrera.taller4.model.UsvInstitution;

@Controller
public class UsvInstitutionControllerImpl {

	private final UsvInstitutionDelegate usvInstitutionDelegate;

	public UsvInstitutionControllerImpl(UsvInstitutionDelegate usvInstitutionDelegate) {
		this.usvInstitutionDelegate = usvInstitutionDelegate;
	}

	@GetMapping("/institution")
	public String indexInstitution(Model model) {
		model.addAttribute("institutions", usvInstitutionDelegate.findAll());
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
			usvInstitutionDelegate.save(institution);
		}
		return "redirect:/institution/";
	}

	@GetMapping("/institution/edit/{id}")
	public String editInstitution(@PathVariable("id") long id, Model model) {
		UsvInstitution inst = usvInstitutionDelegate.findById(id);
		if (inst == null) {
			throw new IllegalArgumentException("Invalid ID " + id);
		}
		model.addAttribute("usvInstitution", inst);
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
			usvInstitutionDelegate.update(institution);
		}
		return "redirect:/institution/";
	}

}
