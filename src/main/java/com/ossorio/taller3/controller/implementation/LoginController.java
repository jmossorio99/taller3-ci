package com.ossorio.taller3.controller.implementation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ossorio.taller3.model.Userr;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("userr", new Userr());
		return "login";
	}

}
