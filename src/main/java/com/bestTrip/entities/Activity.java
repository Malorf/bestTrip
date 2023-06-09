package com.bestTrip.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.bestTrip.models.Adress;

@Entity
@DiscriminatorValue("Activity")
@Table(name = "ACTIVITIES", schema = "best_Trip_db")
public class Activity extends Place implements Serializable {
	
	private boolean free;
	
	public Activity() {
		// TODO Auto-generated constructor stub
	}

	public Activity(String placeName, Adress adress, Float placeRating, Float placeCost, boolean free) {
		super(placeName, adress, placeRating, placeCost);
		this.free = free;
	}

	/**
	 * @return the free
	 */
	public boolean isFree() {
		return free;
	}

	/**
	 * @param free the free to set
	 */
	public void setFree(boolean free) {
		this.free = free;
	}

	@Override
	public String toString() {
		return "Activity [free=" + free + "]";
	}
	
	

}
