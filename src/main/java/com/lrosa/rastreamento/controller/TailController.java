package com.lrosa.rastreamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lrosa.rastreamento.model.Tail;
import com.lrosa.rastreamento.service.TailService;

@RestController
public class TailController {

	@Autowired
	private TailService tailService;

	@PostMapping("tail/add")
	public void add(@RequestBody final Tail tail) {
		tailService.save(tail);
	}

}
