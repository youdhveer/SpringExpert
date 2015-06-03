package com.knowledgeserve;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ClientAppConfig {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.knowledgeserve.wsdl");
		return marshaller;
	}
	@Bean
	public CountryClient countryClient(Jaxb2Marshaller marshaller) {
		CountryClient client = new CountryClient();
		client.setDefaultUri("http://localhost:8080/SpringSoapProducer/soapws/countries.wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
