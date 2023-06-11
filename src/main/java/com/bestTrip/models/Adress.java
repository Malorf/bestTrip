package com.bestTrip.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Adress implements Serializable{

	private String street;
	private String city;
	private Long postalCode;
 
 public Adress() {

}

public Adress(String street, String city, Long postalCode) {

	this.street = street;
	this.city = city;
	this.postalCode = postalCode;
}


public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public Long getPostalCode() {
	return postalCode;
}

public void setPostalCode(Long postalCode) {
	this.postalCode = postalCode;
}

@Override
public String toString() {
	return "Adress [ street=" + street + ", city=" + city + ", postalCode=" + postalCode
			+ "]";
}
 
 
 
}
