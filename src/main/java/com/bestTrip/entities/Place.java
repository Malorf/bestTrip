package com.bestTrip.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.bestTrip.models.Adress;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "PLACES", schema = "best_Trip_db")
public class Place implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlace;
	private String placeName;
	@Embedded
	private Adress adress;
	private Float placeRating;
	private Float placeCost;
	
	@ManyToMany(mappedBy="places", cascade = CascadeType.ALL)
	private List<TravelGuide> placesTravelGuides;
	
	public Place() {
		// TODO Auto-generated constructor stub
	}

	public Place(String placeName, Adress adress, Float placeRating, Float placeCost) {
		super();
		this.placeName = placeName;
		this.adress = adress;
		this.placeRating = placeRating;
		this.placeCost = placeCost;
	}
	
	
	
	public Place(String placeName, Adress adress, Float placeRating, Float placeCost, List<TravelGuide> travelGuides) {
		super();
		this.placeName = placeName;
		this.adress = adress;
		this.placeRating = placeRating;
		this.placeCost = placeCost;
		this.placesTravelGuides = travelGuides;
	}

	public Long getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(Long idPlace) {
		this.idPlace = idPlace;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Float getPlaceRating() {
		return placeRating;
	}

	public void setPlaceRating(Float placeRating) {
		this.placeRating = placeRating;
	}

	public Float getPlaceCost() {
		return placeCost;
	}

	public void setPlaceCost(Float placeCost) {
		this.placeCost = placeCost;
	}

	
	
	public List<String> getTravelGuides() {
		List<String> travelGuidesNames = new ArrayList<>();
		for(TravelGuide travelGuide :placesTravelGuides){
			travelGuidesNames.add(travelGuide.getGuideName());
		}
			return travelGuidesNames;
		
		
		
	}

	public void setTravelGuides(List<TravelGuide> travelGuides) {
		this.placesTravelGuides = travelGuides;
	}

	@Override
	public String toString() {
		return "Place [idPlace=" + idPlace + ", placeName=" + placeName + ", adress=" + adress + ", placeRating="
				+ placeRating + ", placeCost=" + placeCost + ", travelGuides=" + placesTravelGuides + "]";
	}


	
	
	
}
