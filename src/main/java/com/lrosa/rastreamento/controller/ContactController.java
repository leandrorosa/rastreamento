package com.lrosa.rastreamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lrosa.rastreamento.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/contato")
	public ModelAndView listAll() {
		final ModelAndView modelAndView = new ModelAndView("contact/contact");
		modelAndView.addObject("contatos", contactService.findAll());
		return modelAndView;
	}

}
