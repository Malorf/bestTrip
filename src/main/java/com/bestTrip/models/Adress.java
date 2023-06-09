package com.bestTrip.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADRESS", schema = "best_Trip_db")
public class Adress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAdress;
	private String street;
	private String city;
	private Long postalCode;
 
 public Adress() {
	// TODO Auto-generated constructor stub
}

public Adress(String street, String city, Long postalCode) {
	super();
	this.street = street;
	this.city = city;
	this.postalCode = postalCode;
}

public Long getIdAdress() {
	return idAdress;
}

public void setIdAdress(Long idAdress) {
	this.idAdress = idAdress;
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
	return "Adress [idAdress=" + idAdress + ", street=" + street + ", city=" + city + ", postalCode=" + postalCode
			+ "]";
}
 
 
 
}
