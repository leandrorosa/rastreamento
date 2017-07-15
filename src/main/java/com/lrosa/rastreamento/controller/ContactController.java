package com.lrosa.rastreamento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lrosa.rastreamento.model.Contact;
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

	@GetMapping("/contato/add")
	public ModelAndView add(Contact contact) {
		ModelAndView modelAndView = new ModelAndView("/contact/contactAdd");
		modelAndView.addObject("contact", contact);
		return modelAndView;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Contact contact, BindingResult result) {
		if (result.hasErrors()) {
			return add(contact);
		}
		contactService.save(contact);
		return new ModelAndView("redirect:/index.html");
	}

}
