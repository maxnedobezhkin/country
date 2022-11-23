package com.example.country.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    private String countryName;
    private String capitalCity;
    private String phoneCode;
    private String currency;
    private String flag;
    
	public Country(String countryName, String capitalCity, String phoneCode, String currency, String flag) {
		super();
		this.countryName = countryName;
		this.capitalCity = capitalCity;
		this.phoneCode = phoneCode;
		this.currency = currency;
		this.flag = flag;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCapitalCity() {
		return capitalCity;
	}

	public void setCapitalCity(String capitalCity) {
		this.capitalCity = capitalCity;
	}

	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", countryName=" + countryName + ", capitalCity=" + capitalCity + ", phoneCode="
				+ phoneCode + ", currency=" + currency + ", flag=" + flag + "]";
	}
	
}
