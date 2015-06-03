package com.knowledgeserve;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.knowledgeserve.wsdl.GetCountryResponse;



public class RunSoapClient {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	    ctx.register(ClientAppConfig.class);
	    ctx.refresh();
		CountryClient studentClient = ctx.getBean(CountryClient.class);
		System.out.println("For Student Id: 1");
		GetCountryResponse response = studentClient.getCountryByName("Poland");  //Spain,Poland
		System.out.println("Name:"+response.getCountry().getName());
		System.out.println("Population:"+response.getCountry().getPopulation());
		System.out.println("Currency:"+response.getCountry().getCurrency());
	}
}
