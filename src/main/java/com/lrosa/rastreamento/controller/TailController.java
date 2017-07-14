package com.lrosa.rastreamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lrosa.rastreamento.model.Tail;
import com.lrosa.rastreamento.service.TailService;

@RestController
public class TailController {

	@Autowired
	private TailService tailService;

	@PostMapping
	public void add(@RequestParam final Tail tail) {
		tailService.save(tail);
	}

}
