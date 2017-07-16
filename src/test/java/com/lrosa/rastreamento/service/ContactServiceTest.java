package com.lrosa.rastreamento.service;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.lrosa.rastreamento.model.Contact;
import com.lrosa.rastreamento.repository.ContactRepository;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTest {

	@Mock
	private ContactRepository contactRepository;

	@InjectMocks
	private ContactService contactService;

	@Test
	public void saveTest() throws Exception {
		final Contact contact = new Contact("teste@teste.com", "123");
		boolean sucess = contactService.save(contact);
		Assert.assertTrue(sucess);
	}

	@Test
	public void emailExistsSaveTest() throws Exception {
		when(contactRepository.findByEmail(anyString())).thenReturn(new Contact());

		final Contact contact = new Contact("teste@teste.com", "123");
		boolean sucess = contactService.save(contact);
		Assert.assertFalse(sucess);
	}

	@Test
	public void clientIdentifierExistsSaveTest() throws Exception {
		when(contactRepository.findByClientIdentifier(anyString())).thenReturn(new Contact());

		final Contact contact = new Contact("teste@teste.com", "123");
		boolean sucess = contactService.save(contact);
		Assert.assertFalse(sucess);
	}

}
