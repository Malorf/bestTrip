package com.bestTrip.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.bestTrip.models.Adress;

@Entity
@DiscriminatorValue(value ="Hotel")
@Table(name = "HOTELS", schema = "best_Trip_db")
public class Hotel extends Place implements Serializable{

	private int stars;
	
	public Hotel() {
		// TODO Auto-generated constructor stub
	}

	public Hotel(String placeName, Adress adress, Float placeRating, Float placeCost, int stars) {
		super(placeName, adress, placeRating, placeCost);
		this.stars = stars;
	}

	/**
	 * @return the stars
	 */
	public int getStars() {
		return stars;
	}

	/**
	 * @param stars the stars to set
	 */
	public void setStars(int stars) {
		this.stars = stars;
	}

	@Override
	public String toString() {
		return "Hotel [stars=" + stars + "]";
	}
	
	
	
}
