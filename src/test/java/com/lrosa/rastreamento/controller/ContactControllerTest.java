package com.lrosa.rastreamento.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.lrosa.rastreamento.model.Contact;
import com.lrosa.rastreamento.service.ContactService;

@RunWith(MockitoJUnitRunner.class)
public class ContactControllerTest {

	@Mock
	private BindingResult bindingResult;

	@Mock
	private ContactService contactService;

	@InjectMocks
	private ContactController contactController;

	@Test
	public void invalidContactSaveTest() throws Exception {
		when(bindingResult.hasErrors()).thenReturn(true);
		ModelAndView modelAndView = contactController.save(new Contact(), bindingResult);
		Assert.assertEquals("contact/contactAdd", modelAndView.getViewName());
	}

	@Test
	public void alreadySavedTest() throws Exception {
		when(contactService.save(any())).thenReturn(false);
		ModelAndView modelAndView = contactController.save(new Contact(), bindingResult);
		Assert.assertEquals("contact/contactAdd", modelAndView.getViewName());
	}

	@Test
	public void saveTest() throws Exception {
		when(bindingResult.hasErrors()).thenReturn(false);
		when(contactService.save(any())).thenReturn(true);
		ModelAndView modelAndView = contactController.save(new Contact(), bindingResult);
		Assert.assertEquals("redirect:/index.html", modelAndView.getViewName());
	}

}
