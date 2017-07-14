package com.lrosa.rastreamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ByPassController {

	@GetMapping("/")
	public String home() {
		return "pages/index";
	}

	@GetMapping("/preco")
	public String preco() {
		return "pages/preco";
	}
}
