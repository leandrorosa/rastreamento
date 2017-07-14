package com.lrosa.rastreamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrosa.rastreamento.model.Contact;
import com.lrosa.rastreamento.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	public Iterable<Contact> findAll() {
		return contactRepository.findAll();
	}

}
