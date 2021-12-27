package com.spring.security.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.security.dto.MailDTO;
import com.spring.security.service.MailService;

@Controller
@RequestMapping
public class CenlanderController {

	@Autowired
	MailService mailService;

	@GetMapping("/cel")
	public String showCel(Model model, HttpSession session) {

		if (session.getAttribute("email") == null) {
			return "redirect:/login";
		}

		List<MailDTO> dtos = mailService.getListMail(1);
		model.addAttribute("mailDto", dtos);
		return "cenlander";
	}

	@GetMapping("/history")
	public String history(Model model, HttpSession session) {
		if (session.getAttribute("email") == null) {
			return "redirect:/login";
		}
		List<MailDTO> dtos = mailService.getListMail(0);
		model.addAttribute("mailDto", dtos);

		return "cenlander";
	}

	@GetMapping("updateMail/{id}")
	public String formUpdate(@PathVariable("id") int id, Model model) {

		MailDTO dto = mailService.getMailById(id);
		model.addAttribute("mailDto", dto);

		return "updatecel";
	}

	@GetMapping("deleteMail/{id}")
	public String deleteMail(@PathVariable("id") int id) {

		this.mailService.deleteEmployeeById(id);
		return "redirect:/cel";
	}

	@RequestMapping(value = "/sendnow", method = RequestMethod.GET)
	public String formSendNow(HttpSession session, Model model) {

		if (session.getAttribute("email") == null) {
			return "redirect:/login";
		}
		model.addAttribute("email", (String) session.getAttribute("email"));
		return "sendnow";
	}

	@RequestMapping(value = "sendcel", method = RequestMethod.GET)
	public String formSend(HttpSession session, Model model) {
		if (session.getAttribute("email") == null) {
			return "redirect:/login";
		}
		model.addAttribute("email", (String) session.getAttribute("email"));
		
		return "sendcel";
	}

	@PostMapping("/cel")
	public String sendMail(@RequestParam("time") String time, HttpSession session) {
		if (session.getAttribute("email") == null) {
			return "redirect:/login";
		}
		return "redirect:/cel";
	}

	@PostMapping("save")
	public String saveMail(@ModelAttribute("Mail") MailDTO mdto, Model model, HttpSession session) {
		if (session.getAttribute("email") == null) {
			return "redirect:/login";
		}
		mdto.setSendFrom((String) session.getAttribute("email"));
		mailService.insert(mdto);
		return "redirect:/cel";
	}

	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/login";

	}
}
