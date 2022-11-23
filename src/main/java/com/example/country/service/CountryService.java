package com.example.country.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.country.CountryClient;
import com.example.country.entity.Country;
import com.example.country.repository.CountryRepository;

import hello.wsdl.ArrayOftCountryCodeAndName;
import hello.wsdl.ListOfCountryNamesByNameResponse;
import hello.wsdl.TCountryCodeAndName;
import hello.wsdl.TCountryInfo;

@Service
public class CountryService {
	
	@Autowired
	private static CountryRepository countryRepository;
	
	@Autowired
	private static ApplicationContext ctx;
	
	public CountryService(CountryRepository countryRepository, ApplicationContext ctx) {
		CountryService.countryRepository = countryRepository;
		CountryService.ctx = ctx;
	}

	@Scheduled(fixedRateString = "${interval}")
	public static void getAndSaveCountries() {
		CountryClient countryClient = ctx.getBean(CountryClient.class);
		
		ListOfCountryNamesByNameResponse response = countryClient.getListOfCountryNamesByName();
		ArrayOftCountryCodeAndName res = response.getListOfCountryNamesByNameResult();
	    List<TCountryCodeAndName> countryCodeAndNameList = res.getTCountryCodeAndName();
	    List<Country> resultList = new ArrayList<>();
	    for (TCountryCodeAndName countryCodeAndName : countryCodeAndNameList) {
            TCountryInfo fullCountryInfo = countryClient.getFullCountryInfo(countryCodeAndName.getSISOCode()).getFullCountryInfoResult();
            resultList.add(new Country(
            		countryCodeAndName.getSName(),
            		fullCountryInfo.getSCapitalCity(),
            		fullCountryInfo.getSPhoneCode(),
            		fullCountryInfo.getSCurrencyISOCode(),
            		fullCountryInfo.getSCountryFlag()
            		));
	    }
	    
	    for (Country country : resultList) {
	    	countryRepository.save(country);
		}
		
	}
}
