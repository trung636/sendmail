package com.spring.security.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.security.dto.UserDTO;
import com.spring.security.service.UserService;

@Controller
@RequestMapping
public class LoginController {

	@Autowired
	public UserService userService;

	@GetMapping("/")
	public String welcome() {
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login(HttpSession session) {

		return "login";
	}

	@GetMapping("/register")
	public String showRegistrationForm() {
		return "registration";
	}

	@GetMapping("/profile")
	public String profile(HttpSession session, Model model) {

		if (session.getAttribute("email") == null) {
			return "redirect:/login";
		}

		String email = session.getAttribute("email").toString();
		model.addAttribute("dtos", userService.findByEmail(email));
		return "profile";
	}

	@PostMapping("/checkLogin")
	public String home(Model model, @ModelAttribute UserDTO u, HttpSession session) {

		if (userService.logger(u) == null) {
			return "redirect:/login?fail";
		}
		String check = userService.checkLogin(u, session);
		if (check.equals("Success")) {
			return "redirect:/profile";
		}
		return "redirect:/login?fail";

	}

	@PostMapping("/register")
	public String registerUserAccount(@ModelAttribute("userDTO") UserDTO udto) {
		userService.save(udto);
		return "redirect:/login";
	}

	@PostMapping("/update")
	public String updateProfile(@ModelAttribute UserDTO userDTO, Model model, HttpSession session) {
		if (session.getAttribute("email") == null) {
			return "redirect:/login";
		}
		String email = session.getAttribute("email").toString();
		UserDTO a = userService.findByEmail(email);
		model.addAttribute("dtos", a);
		userService.save(userDTO);
		return "redirect:/profile?success";
	}

}
