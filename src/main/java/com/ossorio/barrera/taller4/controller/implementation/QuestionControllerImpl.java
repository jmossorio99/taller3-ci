package com.ossorio.barrera.taller4.controller.implementation;

import com.ossorio.barrera.taller4.delegate.interfaces.SymptomDelegate;
import com.ossorio.barrera.taller4.delegate.interfaces.SymptompollDelegate;
import com.ossorio.barrera.taller4.delegate.interfaces.SymptomquestionDelegate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ossorio.barrera.taller4.model.Symptomquestion;
import com.ossorio.barrera.taller4.service.interfaces.SymptomService;
import com.ossorio.barrera.taller4.service.interfaces.SymptompollService;

@Controller
public class QuestionControllerImpl {

	private final SymptomquestionDelegate sympquesDelegate;
	private final SymptompollDelegate symptompollDelegate;
	private final SymptomDelegate symptomDelegate;

	public QuestionControllerImpl(SymptomquestionDelegate sympquesDelegate, SymptompollDelegate symptompollDelegate,
								  SymptomDelegate symptomDelegate) {
		this.sympquesDelegate = sympquesDelegate;
		this.symptompollDelegate = symptompollDelegate;
		this.symptomDelegate = symptomDelegate;
	}

	@GetMapping("/question")
	public String questionIndex(Model model) {
		model.addAttribute("questions", sympquesDelegate.findAll());
		return "questions/index";
	}

	@GetMapping("/question/add")
	public String addQuestion(Model model) {
		model.addAttribute("symptomquestion", new Symptomquestion());
		model.addAttribute("symptompolls", symptompollDelegate.findAll());
		model.addAttribute("symptoms", symptomDelegate.findAll());
		return "questions/add-question";
	}

	@PostMapping("/question/add")
	public String saveQuestion(@RequestParam(value = "action", required = true) String action,
							   @Validated @ModelAttribute Symptomquestion sympques, BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				System.out.println(bindingResult.getAllErrors().toString());
				model.addAttribute("symptompolls", symptompollDelegate.findAll());
				model.addAttribute("symptoms", symptomDelegate.findAll());
				return "questions/add-question";
			}
			sympquesDelegate.save(sympques);
		}
		return "redirect:/question/";
	}

	@GetMapping("/question/edit/{id}")
	public String updateQuestion(@PathVariable("id") long id, Model model) {
		model.addAttribute("symptompolls", symptompollDelegate.findAll());
		model.addAttribute("symptoms", symptomDelegate.findAll());
		model.addAttribute("symptomquestion", sympquesDelegate.findById(id));
		return "questions/edit-question";
	}

	@PostMapping("/question/edit/{id}")
	public String updateQuestionPost(@RequestParam(value = "action", required = true) String action,
									 @PathVariable("id") long id, @Validated @ModelAttribute Symptomquestion question,
									 BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				System.out.println(bindingResult.getAllErrors().toString());
				model.addAttribute("symptompolls", symptompollDelegate.findAll());
				model.addAttribute("symptoms", symptomDelegate.findAll());
				return "questions/edit-question";
			}
			question.setSympquesId(id);
			sympquesDelegate.update(question);
		}
		return "redirect:/question/";
	}

	@GetMapping("/question/{id}/weights")
	public String getQuestionWeights(@PathVariable("id") long id, Model model) {
		model.addAttribute("weights", sympquesDelegate.findById(id).getSympweightbydays());
		return "questions/question-weights";
	}

}
