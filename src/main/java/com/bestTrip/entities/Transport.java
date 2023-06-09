package com.bestTrip.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "TRANSPORTS", schema = "best_Trip_db")
public class Transport implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTransport;
	private Float transportCost;
	private String nameCompany;
	private Float transportRating;
	private Float timeTravel;
	//private SyndFeed rss;
	
	public Transport() {
		// TODO Auto-generated constructor stub
	}
	public Transport(Float transportCost, String nameCompany, Float transportRating, Float timeTravel) {
		super();
		this.transportCost = transportCost;
		this.nameCompany = nameCompany;
		this.transportRating = transportRating;
		this.timeTravel = timeTravel;
	}
	public Long getIdTransport() {
		return idTransport;
	}
	public void setIdTransport(Long idTransport) {
		this.idTransport = idTransport;
	}
	public Float getTransportCost() {
		return transportCost;
	}
	public void setTransportCost(Float transportCost) {
		this.transportCost = transportCost;
	}
	public String getNameCompany() {
		return nameCompany;
	}
	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}
	public Float getTransportRating() {
		return transportRating;
	}
	public void setTransportRating(Float transportRating) {
		this.transportRating = transportRating;
	}
	public Float getTimeTravel() {
		return timeTravel;
	}
	public void setTimeTravel(Float timeTravel) {
		this.timeTravel = timeTravel;
	}
	@Override
	public String toString() {
		return "Transport [idTransport=" + idTransport + ", transportCost=" + transportCost + ", nameCompany="
				+ nameCompany + ", transportRating=" + transportRating + ", timeTravel=" + timeTravel + "]";
	}
	
	
}