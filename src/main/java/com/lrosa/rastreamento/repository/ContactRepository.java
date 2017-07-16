package com.lrosa.rastreamento.repository;

import org.springframework.data.repository.CrudRepository;

import com.lrosa.rastreamento.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>{

	Contact findByClientIdentifier(final String clientIdentifier);

	Contact findByEmail(final String email);

}
