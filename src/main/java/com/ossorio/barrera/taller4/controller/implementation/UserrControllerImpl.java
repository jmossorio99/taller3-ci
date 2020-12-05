package com.ossorio.barrera.taller4.controller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ossorio.barrera.taller4.service.implementation.UserrServiceImpl;

@Controller
public class UserrControllerImpl {

	UserrServiceImpl userService;

	@Autowired
	public UserrControllerImpl(UserrServiceImpl userService) {
		this.userService = userService;
	}

	@GetMapping("/users/")
	public String indexUser(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users/index";
	}

}
