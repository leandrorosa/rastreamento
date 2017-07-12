package com.lrosa.rastreamento;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class RastreamentoApplication {

	public static void main(final String[] args) {
		SpringApplication.run(RastreamentoApplication.class, args);
	}

	@Bean
    ServletRegistrationBean h2servletRegistration(){
        final ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}
