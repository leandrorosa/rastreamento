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

	public boolean save(final Contact contact) {
		if(contactRepository.findByClientIdentifier(contact.getClientIdentifier()) != null) {
			return false;
		}
		if(contactRepository.findByEmail(contact.getEmail()) != null) {
			return false;
		}

		contactRepository.save(contact);
		return true;
	}

	public Contact findByClientIdentifier(final String clientIdentifier) {
		return contactRepository.findByClientIdentifier(clientIdentifier);
	}

}
