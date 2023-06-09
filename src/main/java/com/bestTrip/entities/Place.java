package com.bestTrip.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.bestTrip.model.Adress;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "PLACES", schema = "best_Trip_db")
public class Place implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlace;
	private String placeName;
	private Adress adress;
	private Float placeRating;
	private Float placeCost;
	
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

	@Override
	public String toString() {
		return "Place [idPlace=" + idPlace + ", placeName=" + placeName + ", adress=" + adress + ", placeRating="
				+ placeRating + ", placeCost=" + placeCost + "]";
	}
	
	
	
}
