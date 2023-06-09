package com.bestTrip.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TRAVELGUIDES", schema = "best_trip_db")
public class TravelGuide implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTravelGuide;
	private String guideName;
	private float globalRating;
	private String countryName;
	private float totalCost;
	public enum statusTravelGuide{waiting, approved, refused;}
	public statusTravelGuide statusTravelGuide ;
	public Account approvedBy;
	@Temporal (TemporalType.DATE)
	private Date updateTravelGuide;
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="idAccount")
	private Account accountTravelGuide;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="TYPEPLACE",
	joinColumns=@JoinColumn(name="idTravelguide",
	referencedColumnName="idTravelGuide"),
	inverseJoinColumns =@JoinColumn(name = "idPlace", referencedColumnName="idPlace" ))
	private Set<Place> places = new HashSet <> ();
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="TYPETRANSPORT",
	joinColumns=@JoinColumn(name="idTravelguide",
	referencedColumnName="idTravelGuide"),
	inverseJoinColumns =@JoinColumn(name = "idTransport", referencedColumnName="idTransport" ))
	private Set<Transport> transports = new HashSet <> ();
	
	public TravelGuide() {
	
		
	}

	public TravelGuide(String guideName, float globalRating, String countryName, float totalCost,
			com.bestTrip.entities.TravelGuide.statusTravelGuide statusTravelGuide, Account approvedBy,
			Date updateTravelGuide, Account accountTravelGuide) {
		this.guideName = guideName;
		this.globalRating = globalRating;
		this.countryName = countryName;
		this.totalCost = totalCost;
		this.statusTravelGuide = statusTravelGuide;
		this.approvedBy = approvedBy;
		this.updateTravelGuide = updateTravelGuide;
		this.accountTravelGuide = accountTravelGuide;
	}

	public TravelGuide(String guideName, float globalRating, String countryName, float totalCost,
			com.bestTrip.entities.TravelGuide.statusTravelGuide statusTravelGuide, Account approvedBy,
			Date updateTravelGuide, Account accountTravelGuide, Set<Place> places, Set<Transport> transports) {
		this.guideName = guideName;
		this.globalRating = globalRating;
		this.countryName = countryName;
		this.totalCost = totalCost;
		this.statusTravelGuide = statusTravelGuide;
		this.approvedBy = approvedBy;
		this.updateTravelGuide = updateTravelGuide;
		this.accountTravelGuide = accountTravelGuide;
		this.places = places;
		this.transports = transports;
	}

	public Long getIdTravelGuide() {
		return idTravelGuide;
	}

	public void setIdTravelGuide(Long idTravelGuide) {
		this.idTravelGuide = idTravelGuide;
	}

	public String getGuideName() {
		return guideName;
	}

	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}

	public float getGlobalRating() {
		return globalRating;
	}

	public void setGlobalRating(float globalRating) {
		this.globalRating = globalRating;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public statusTravelGuide getStatusTravelGuide() {
		return statusTravelGuide;
	}

	public void setStatusTravelGuide(statusTravelGuide statusTravelGuide) {
		this.statusTravelGuide = statusTravelGuide;
	}

	public Account getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(Account approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getUpdateTravelGuide() {
		return updateTravelGuide;
	}

	public void setUpdateTravelGuide(Date updateTravelGuide) {
		this.updateTravelGuide = updateTravelGuide;
	}

	public Account getAccountTravelGuide() {
		return accountTravelGuide;
	}

	public void setAccountTravelGuide(Account accountTravelGuide) {
		this.accountTravelGuide = accountTravelGuide;
	}

	public Set<Place> getPlaces() {
		return places;
	}

	public void setPlaces(Set<Place> places) {
		this.places = places;
	}

	public Set<Transport> getTransports() {
		return transports;
	}

	public void setTransports(Set<Transport> transports) {
		this.transports = transports;
	}

	@Override
	public String toString() {
		return "TravelGuide [idTravelGuide=" + idTravelGuide + ", guideName=" + guideName + ", globalRating="
				+ globalRating + ", countryName=" + countryName + ", totalCost=" + totalCost + ", statusTravelGuide="
				+ statusTravelGuide + ", approvedBy=" + approvedBy + ", updateTravelGuide=" + updateTravelGuide
				+ ", accountTravelGuide=" + accountTravelGuide + ", places=" + places + ", transports=" + transports
				+ "]";
	}
	
	
}