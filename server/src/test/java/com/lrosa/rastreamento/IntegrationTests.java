package com.lrosa.rastreamento;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.lrosa.rastreamento.model.Contact;
import com.lrosa.rastreamento.model.Tail;
import com.lrosa.rastreamento.repo.ContactRepository;
import com.lrosa.rastreamento.repo.TailRepository;


/**
 * Teste de integração utilizando banco de dados em memória
 * @author lrosa
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/test.properties")
public class IntegrationTests {

    @Autowired
    private TailRepository tailRepository;

    @Autowired
    private ContactRepository contactRepository;

    /**
     *  O visitante "A" acessa a página "Home" da sua página de exemplo.
         O visitante "A" acessa a página de "Preço" da sua página de exemplo.
         O visitante "B" acessa a página "Home" da sua página de exemplo.
         O visitante "B" acessa a página "Contato" da sua página de exemplo.
         O visitante "B" preenche o formulário e confirma.
         É criado um contato em sua aplicação para o Visitante "B".
         Ao acessar a página do Visitante "B" na aplicação é possível ver as seguintes páginas:
        Home
        Contato
        O visitante "A" acessa a página "Contato" da sua página de exemplo.
        O visitante "A" preenche o formulário e confirma.
        É criado um contato em sua aplicação para o Visitante "A".
        Ao acessar a página do Visitante "A" na aplicação é possível ver as seguintes páginas:
        Home
        Preço
        Contato
        O visitante "B" acessa a página "Sobre" da página de exemplo.
        Ao acessar a página do visitante "B" na aplicação é possível ver as seguintes páginas:
        Home
        Contato
        Sobre
     */
	@Test
	public void twoUsersTest() {

	    final String firstUserIdentifier = "first";
	    tailRepository.save(new Tail(firstUserIdentifier, "home"));
	    tailRepository.save(new Tail(firstUserIdentifier, "preco"));

	    final String secondUserIdentifier = "second";
        tailRepository.save(new Tail(secondUserIdentifier, "home"));
        tailRepository.save(new Tail(secondUserIdentifier, "contato"));

        contactRepository.save(new Contact("second@user.com", secondUserIdentifier));

        List<Tail> secondUserVisitedPages = tailRepository.findByClientIdentifier(secondUserIdentifier);
        Assert.assertEquals(2, secondUserVisitedPages.size());
        Assert.assertEquals("home", secondUserVisitedPages.get(0).getPage());
        Assert.assertEquals("contato", secondUserVisitedPages.get(1).getPage());

        tailRepository.save(new Tail(firstUserIdentifier, "contato"));

        contactRepository.save(new Contact("first@user.com", firstUserIdentifier));

        final List<Tail> firstUserVisitedPages = tailRepository.findByClientIdentifier(firstUserIdentifier);
        Assert.assertEquals(3, firstUserVisitedPages.size());
        Assert.assertEquals("home", firstUserVisitedPages.get(0).getPage());
        Assert.assertEquals("preco", firstUserVisitedPages.get(1).getPage());
        Assert.assertEquals("contato", firstUserVisitedPages.get(2).getPage());

        tailRepository.save(new Tail(secondUserIdentifier, "sobre"));
        secondUserVisitedPages = tailRepository.findByClientIdentifier(secondUserIdentifier);
        Assert.assertEquals(3, secondUserVisitedPages.size());
        Assert.assertEquals("home", secondUserVisitedPages.get(0).getPage());
        Assert.assertEquals("contato", secondUserVisitedPages.get(1).getPage());
        Assert.assertEquals("sobre", secondUserVisitedPages.get(2).getPage());
	}

	@After
	public void clearInMemoryData() {
	    tailRepository.deleteAll();
	    contactRepository.deleteAll();
	}



}
