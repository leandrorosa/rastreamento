package com.lrosa.rastreamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.lrosa.rastreamento.service.ContactService;
import com.lrosa.rastreamento.service.TailService;

@Controller
public class TailController {

	@Autowired
	private TailService tailService;

	@Autowired
	private ContactService contactService;

	@GetMapping("tail/{clientIdentifier}")
	public ModelAndView listByClientIdentifier(@PathVariable("clientIdentifier") final String clientIdentifier) {
		final ModelAndView modelAndView = new ModelAndView("/tail/tail");
		modelAndView.addObject("tails", tailService.findByClientIdentifier(clientIdentifier));

		modelAndView.addObject("contact", contactService.findByClientIdentifier(clientIdentifier));
		return modelAndView;
	}

}
