package com.ossorio.barrera.taller4.controller.implementation;

import com.ossorio.barrera.taller4.delegate.interfaces.EpidemeventDelegate;
import com.ossorio.barrera.taller4.delegate.interfaces.SymptompollDelegate;
import com.ossorio.barrera.taller4.delegate.interfaces.SymptomquestionDelegate;
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

import com.ossorio.barrera.taller4.model.Symptompoll;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PollControllerImpl {

	private final SymptompollDelegate symptompollDelegate;
	private final EpidemeventDelegate epidemeventDelegate;
	private final UsvInstitutionDelegate usvInstitutionDelegate;
	private final SymptomquestionDelegate symptomquestionDelegate;

	public PollControllerImpl(SymptompollDelegate symptompollDelegate, EpidemeventDelegate epidemeventDelegate,
							  UsvInstitutionDelegate usvInstitutionDelegate, SymptomquestionDelegate symptomquestionDelegate) {
		this.symptompollDelegate = symptompollDelegate;
		this.epidemeventDelegate = epidemeventDelegate;
		this.usvInstitutionDelegate = usvInstitutionDelegate;
		this.symptomquestionDelegate = symptomquestionDelegate;
	}

	@GetMapping("/poll")
	public String indexPolls(Model model) {
		model.addAttribute("polls", symptompollDelegate.findAll());
		return "poll/index";
	}

	@GetMapping("/poll/add")
	public String addPoll(Model model) {
		model.addAttribute("symptompoll", new Symptompoll());
		model.addAttribute("epidemevents", epidemeventDelegate.findAll());
		model.addAttribute("institutions", usvInstitutionDelegate.findAll());
		return "poll/add-poll";
	}

	@PostMapping("/poll/add")
	public String savePoll(@RequestParam(value = "action", required = true) String action,
			@Validated @ModelAttribute Symptompoll symptompoll, BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				System.out.println(bindingResult.getAllErrors().toString());
				model.addAttribute("epidemevents", epidemeventDelegate.findAll());
				model.addAttribute("institutions", usvInstitutionDelegate.findAll());
				return "poll/add-poll";
			}
			symptompollDelegate.save(symptompoll);
		}
		return "redirect:/poll/";
	}

	@GetMapping("/poll/edit/{id}")
	public String editPoll(@PathVariable("id") long id, Model model) {
		model.addAttribute("symptompoll", symptompollDelegate.findById(id));
		model.addAttribute("epidemevents", epidemeventDelegate.findAll());
		model.addAttribute("institutions", usvInstitutionDelegate.findAll());
		return "poll/edit-poll";
	}

	@PostMapping("/poll/edit/{id}")
	public String editPollPost(@RequestParam(value = "action", required = true) String action,
			@PathVariable("id") long id, @Validated @ModelAttribute Symptompoll symptompoll,
			BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				System.out.println(bindingResult.getAllErrors().toString());
				model.addAttribute("epidemevents", epidemeventDelegate.findAll());
				model.addAttribute("institutions", usvInstitutionDelegate.findAll());
				return "poll/edit-poll";
			}
			symptompoll.setSympollId(id);
			symptompollDelegate.update(symptompoll);
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
		model.addAttribute("institution", usvInstitutionDelegate.findById(symptompollDelegate.findById(id).getInstInstId()));
		return "poll/poll-institution";
	}

	@GetMapping("/poll/find-by-date")
	public String findByDate(@RequestParam(value = "startDate", required = true) String startDate, @RequestParam(value = "endDate", required = true) String endDate, Model model){
		if (startDate == null || endDate == null){
			return "poll/index";
		}
		List<Symptompoll> symptompolls = symptompollDelegate.findByDate(startDate, endDate);
		model.addAttribute("symptompolls", symptompolls);
		return "poll/find-by-date";
	}

	@GetMapping("/poll/find-by-date-ordered")
	public String findByDate(@RequestParam(value = "date", required = true) String date, Model model){
		if (date == null){
			return "poll/index";
		}
		List<Symptompoll> symptompolls = symptompollDelegate.findByDateOrdered(date);
		model.addAttribute("symptompolls", symptompolls);
		return "poll/find-by-date-ordered";
	}

}
