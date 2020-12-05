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

import com.ossorio.barrera.taller4.model.Symptomquestion;
import com.ossorio.barrera.taller4.service.interfaces.SymptomService;
import com.ossorio.barrera.taller4.service.interfaces.SymptompollService;
import com.ossorio.barrera.taller4.service.interfaces.SymptomquestionService;

@Controller
public class QuestionControllerImpl {

	private final SymptomquestionService sympquestionService;
	private final SymptompollService symptompollService;
	private final SymptomService symptomService;

	public QuestionControllerImpl(SymptomquestionService sympquestionService, SymptompollService symptompollService,
			SymptomService symptomService) {
		this.sympquestionService = sympquestionService;
		this.symptompollService = symptompollService;
		this.symptomService = symptomService;
	}

	@GetMapping("/question")
	public String questionIndex(Model model) {
		model.addAttribute("questions", sympquestionService.findAll());
		return "questions/index";
	}

	@GetMapping("/question/add")
	public String addQuestion(Model model) {
		model.addAttribute("symptomquestion", new Symptomquestion());
		model.addAttribute("symptompolls", symptompollService.findAll());
		model.addAttribute("symptoms", symptomService.findAll());
		return "questions/add-question";
	}

	@PostMapping("/question/add")
	public String saveQuestion(@RequestParam(value = "action", required = true) String action,
			@Validated @ModelAttribute Symptomquestion sympques, BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				System.out.println(bindingResult.getAllErrors().toString());
				model.addAttribute("symptompolls", symptompollService.findAll());
				model.addAttribute("symptoms", symptomService.findAll());
				return "questions/add-question";
			}
			sympquestionService.save(sympques, sympques.getSymptom().getSympId(),
					sympques.getSymptompoll().getSympollId());
		}
		return "redirect:/question/";
	}

	@GetMapping("/question/edit/{id}")
	public String updateQuestion(@PathVariable("id") long id, Model model) {
		model.addAttribute("symptompolls", symptompollService.findAll());
		model.addAttribute("symptoms", symptomService.findAll());
		model.addAttribute("symptomquestion", sympquestionService.findById(id));
		return "questions/edit-question";
	}

	@PostMapping("/question/edit/{id}")
	public String updateQuestionPost(@RequestParam(value = "action", required = true) String action,
			@PathVariable("id") long id, @Validated @ModelAttribute Symptomquestion question,
			BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				System.out.println(bindingResult.getAllErrors().toString());
				model.addAttribute("symptompolls", symptompollService.findAll());
				model.addAttribute("symptoms", symptomService.findAll());
				return "questions/edit-question";
			}
			question.setSympquesId(id);
			sympquestionService.save(question, question.getSymptom().getSympId(),
					question.getSymptompoll().getSympollId());
		}
		return "redirect:/question/";
	}

	@GetMapping("/question/{id}/weights")
	public String getQuestionWeights(@PathVariable("id") long id, Model model) {
		model.addAttribute("weights", sympquestionService.findById(id).getSympweightbydays());
		return "questions/question-weights";
	}

}
