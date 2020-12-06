package com.ossorio.barrera.taller4.controller.implementation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ossorio.barrera.taller4.model.Sympweightbyday;
import com.ossorio.barrera.taller4.service.interfaces.SymptomquestionService;
import com.ossorio.barrera.taller4.delegate.interfaces.SymptomWeightDelegate;

@Controller
public class WeightControllerImpl {

	private final SymptomWeightDelegate symptomWeightDelegate;
	private final SymptomquestionService questionService;

	public WeightControllerImpl(SymptomWeightDelegate symptomWeightDelegate, SymptomquestionService questionService) {
		this.symptomWeightDelegate = symptomWeightDelegate;
		this.questionService = questionService;
	}

	@GetMapping("/weight")
	public String weightIndex(Model model) {
		model.addAttribute("weights", symptomWeightDelegate.getAll());
		return "weight/index";
	}

	@GetMapping("/weight/add")
	public String weightAdd(Model model) {
		model.addAttribute("sympweightbyday", new Sympweightbyday());
		model.addAttribute("symptomquestions", questionService.findAll());
		return "weight/add-weight";
	}

	@PostMapping("/weight/add")
	public String savePoll(@RequestParam(value = "action", required = true) String action,
			@Validated @ModelAttribute Sympweightbyday weight, BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				System.out.println(bindingResult.getAllErrors().toString());
				model.addAttribute("symptomquestion", questionService.findAll());
				return "weight/add-weight";
			}
			symptomWeightDelegate.save(weight, weight.getSymptomquestion().getSympquesId());
		}
		return "redirect:/weight/";
	}

	@GetMapping("/weight/edit/{id}")
	public String editWeight(@PathVariable("id") long id, Model model) {
		model.addAttribute("sympweightbyday", symptomWeightDelegate.findById(id));
		model.addAttribute("symptomquestions", questionService.findAll());
		return "weight/edit-weight";
	}

	@PostMapping("/weight/edit/{id}")
	public String savePoll(@RequestParam(value = "action", required = true) String action, @PathVariable("id") long id,
			@Validated @ModelAttribute Sympweightbyday weight, BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				System.out.println(bindingResult.getAllErrors().toString());
				model.addAttribute("symptomquestion", questionService.findAll());
				return "weight/edit-weight";
			}
			weight.setSympweidaysId(id);
			symptomWeightDelegate.save(weight, weight.getSymptomquestion().getSympquesId());
		}
		return "redirect:/weight/";
	}

}
