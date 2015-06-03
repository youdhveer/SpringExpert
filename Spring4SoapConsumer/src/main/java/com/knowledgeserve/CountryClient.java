package com.knowledgeserve;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.knowledgeserve.wsdl.GetCountryRequest;
import com.knowledgeserve.wsdl.GetCountryResponse;



public class CountryClient extends WebServiceGatewaySupport  {
	public GetCountryResponse getCountryByName(String name) {
		GetCountryRequest request = new GetCountryRequest();
		request.setName(name);
		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback("http://localhost:8080/SpringSoapProducer/soapws/getCountryResponse"));
		return response;
	}
}
