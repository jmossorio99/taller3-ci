package com.ossorio.barrera.taller4.controller.implementation;

import com.ossorio.barrera.taller4.delegate.interfaces.SymptompollDelegate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ossorio.barrera.taller4.model.Symptompoll;
import com.ossorio.barrera.taller4.service.interfaces.EpidemeventService;
import com.ossorio.barrera.taller4.service.interfaces.SymptomquestionService;
import com.ossorio.barrera.taller4.service.interfaces.UsvInstitutionService;

@Controller
public class PollControllerImpl {

	private final SymptompollDelegate symptompollDelegate;
	private final EpidemeventService epidemeventService;
	private final UsvInstitutionService instService;
	private final SymptomquestionService symptomquestionService;

	public PollControllerImpl(SymptompollDelegate symptompollDelegate, EpidemeventService epidemeventService,
							  UsvInstitutionService instService, SymptomquestionService symptomquestionService) {
		this.symptompollDelegate = symptompollDelegate;
		this.epidemeventService = epidemeventService;
		this.instService = instService;
		this.symptomquestionService = symptomquestionService;
	}

	@GetMapping("/poll")
	public String indexPolls(Model model) {
		model.addAttribute("polls", symptompollDelegate.getAll());
		return "poll/index";
	}

	@GetMapping("/poll/add")
	public String addPoll(Model model) {
		model.addAttribute("symptompoll", new Symptompoll());
		model.addAttribute("epidemevents", epidemeventService.findAll());
		model.addAttribute("institutions", instService.findAll());
		return "poll/add-poll";
	}

	@PostMapping("/poll/add")
	public String savePoll(@RequestParam(value = "action", required = true) String action,
			@Validated @ModelAttribute Symptompoll symptompoll, BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				System.out.println(bindingResult.getAllErrors().toString());
				model.addAttribute("epidemevents", epidemeventService.findAll());
				model.addAttribute("institutions", instService.findAll());
				return "poll/add-poll";
			}
			symptompollDelegate.save(symptompoll);
		}
		return "redirect:/poll/";
	}

	@GetMapping("/poll/edit/{id}")
	public String editPoll(@PathVariable("id") long id, Model model) {
		model.addAttribute("symptompoll", symptompollDelegate.findById(id));
		model.addAttribute("epidemevents", epidemeventService.findAll());
		model.addAttribute("institutions", instService.findAll());
		return "poll/edit-poll";
	}

	@PostMapping("/poll/edit/{id}")
	public String editPollPost(@RequestParam(value = "action", required = true) String action,
			@PathVariable("id") long id, @Validated @ModelAttribute Symptompoll symptompoll,
			BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				System.out.println(bindingResult.getAllErrors().toString());
				model.addAttribute("epidemevents", epidemeventService.findAll());
				model.addAttribute("institutions", instService.findAll());
				return "poll/edit-poll";
			}
			symptompoll.setSympollId(id);
			symptompollDelegate.save(symptompoll);
		}
		return "redirect:/poll/";
	}

	@GetMapping("/poll/{id}/questions")
	public String showPollQuestions(@PathVariable("id") long id, Model model) {
		model.addAttribute("questions", symptompollDelegate.findById(id).getSymptomquestions());
		return "poll/poll-questions";
	}

	@GetMapping("/poll/{id}/institution")
	public String showPollInstitution(@PathVariable("id") long id, Model model) {
		model.addAttribute("institution", instService.findById(symptompollDelegate.findById(id).getInstInstId()));
		return "poll/poll-institution";
	}

}
