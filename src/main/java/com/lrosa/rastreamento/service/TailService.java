package com.lrosa.rastreamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrosa.rastreamento.model.Tail;
import com.lrosa.rastreamento.repository.TailRepository;

@Service
public class TailService {

	@Autowired
	private TailRepository tailRepository;

	public void save(final Tail tail) {
		tailRepository.save(tail);
	}

}
