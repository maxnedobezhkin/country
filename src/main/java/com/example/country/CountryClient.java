package com.example.country;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import hello.wsdl.FullCountryInfo;
import hello.wsdl.FullCountryInfoResponse;
import hello.wsdl.ListOfCountryNamesByCode;
import hello.wsdl.ListOfCountryNamesByCodeResponse;
import hello.wsdl.ListOfCountryNamesByName;
import hello.wsdl.ListOfCountryNamesByNameResponse;

public class CountryClient extends WebServiceGatewaySupport {
	
	 public ListOfCountryNamesByNameResponse getListOfCountryNamesByName() {
	        ListOfCountryNamesByName request = new ListOfCountryNamesByName();

	        ListOfCountryNamesByNameResponse response = (ListOfCountryNamesByNameResponse) getWebServiceTemplate().marshalSendAndReceive(
	                request,
	                new SoapActionCallback(
	                        "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso/ListOfContinentsByCode"));

	        return response;
	    }

	    public FullCountryInfoResponse getFullCountryInfo(String countryIsoCode) {
	        FullCountryInfo request = new FullCountryInfo();
	        request.setSCountryISOCode(countryIsoCode);

	        FullCountryInfoResponse response = (FullCountryInfoResponse) getWebServiceTemplate().marshalSendAndReceive(
	                request,
	                new SoapActionCallback(
	                        "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso/ListOfContinentsByCode"));

	        return response;
	    }

}
