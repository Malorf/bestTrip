package com.bestTrip.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
	@Temporal (TemporalType.DATE)
	private Date updateTravelGuide;
	
	//Variable to check
	public enum StatusTravelGuide{waiting, approved, refused;}
	private StatusTravelGuide statusTravelGuide;
	
	//Relations
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="idAccount")
	private Account accountTravelGuide;
	
	@ManyToMany
	@JoinTable(name="travel_guides_places", joinColumns=@JoinColumn(name="travel_guide_id"), inverseJoinColumns =@JoinColumn(name="place_id"))
	private List<Place> places;
	
	@ManyToMany
	@JoinTable(name="travel_guides_transports", joinColumns=@JoinColumn(name="travel_guide_id"), inverseJoinColumns =@JoinColumn(name="transport_id"))
	private List<Transport> transports;
	
	public TravelGuide() {
	
		
	}

	public TravelGuide(String guideName, float globalRating, String countryName, float totalCost,
			StatusTravelGuide statusTravelGuide,
			Date updateTravelGuide, Account accountTravelGuide) {
		this.guideName = guideName;
		this.globalRating = globalRating;
		this.countryName = countryName;
		this.totalCost = totalCost;
		this.statusTravelGuide = statusTravelGuide;
		this.updateTravelGuide = updateTravelGuide;
		this.accountTravelGuide = accountTravelGuide;
	}

	
	
	public TravelGuide(String guideName, float globalRating, String countryName, float totalCost,
			Date updateTravelGuide, StatusTravelGuide statusTravelGuide, Account accountTravelGuide, List<Place> places,
			List<Transport> transports) {
		super();
		this.guideName = guideName;
		this.globalRating = globalRating;
		this.countryName = countryName;
		this.totalCost = totalCost;
		this.updateTravelGuide = updateTravelGuide;
		this.statusTravelGuide = statusTravelGuide;
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

	public StatusTravelGuide getStatusTravelGuide() {
		return statusTravelGuide;
	}

	public void setStatusTravelGuide(StatusTravelGuide statusTravelGuide) {
		this.statusTravelGuide = statusTravelGuide;
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

	@Override
	public String toString() {
		return "TravelGuide [idTravelGuide=" + idTravelGuide + ", guideName=" + guideName + ", globalRating="
				+ globalRating + ", countryName=" + countryName + ", totalCost=" + totalCost + ", updateTravelGuide="
				+ updateTravelGuide + ", statusTravelGuide=" + statusTravelGuide + ", accountTravelGuide="
				+ accountTravelGuide + ", places=" + places + ", transports=" + transports + "]";
	}
	
}