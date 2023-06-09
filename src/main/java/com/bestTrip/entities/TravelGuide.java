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
	public enum statusTravelGuide {waiting, approved, refused};
	public Account approvedBy;
	@Temporal (TemporalType.DATE)
	private Date updateTravelGuide;
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
	private Set<Place> places = new HashSet <> ();
	
	public TravelGuide() {
	
		
	}
	public TravelGuide(String guideName, float globalRating, String coutryName, float totalCost, Account approvedBy,
			Date updateTravelGuide) {
		this.guideName = guideName;
		this.globalRating = globalRating;
		this.countryName = coutryName;
		this.totalCost = totalCost;
		this.approvedBy = approvedBy;
		this.updateTravelGuide = updateTravelGuide;
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
	public String getCoutryName() {
		return countryName;
	}
	public void setCoutryName(String coutryName) {
		this.countryName = coutryName;
	}
	public float getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
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
	@Override
	public String toString() {
		return "TravelGuide [idTravelGuide=" + idTravelGuide + ", guideName=" + guideName + ", globalRating="
				+ globalRating + ", countryName=" + countryName + ", totalCost=" + totalCost + ", updateTravelGuide="
				+ updateTravelGuide + "]";
	}
	
}