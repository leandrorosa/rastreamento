package com.lrosa.rastreamento.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lrosa.rastreamento.model.Contact;

@RepositoryRestResource(collectionResourceRel = "contact", path = "contact")
public interface ContactRepository extends CrudRepository<Contact, Long>{

}
