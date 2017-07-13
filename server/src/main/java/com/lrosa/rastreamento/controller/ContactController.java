package com.lrosa.rastreamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lrosa.rastreamento.model.Contact;
import com.lrosa.rastreamento.repo.ContactRepository;

@RestController
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping(value = "/contact/ola")
    public String olaMundo() {
        return "ola mundo";
    }

    @GetMapping(value = "/contact/create")
    public void createContact() {
        final Contact contact = new Contact("leandro.rosagf@gmail.com");
        contactRepository.save(contact);

    }

    @GetMapping(value = "contact/list")
    public Iterable<Contact> list() {
        return contactRepository.findAll();
    }

}
