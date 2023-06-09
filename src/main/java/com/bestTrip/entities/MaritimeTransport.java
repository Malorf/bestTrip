package com.bestTrip.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@DiscriminatorValue("MaritimeTransport")
@Table(name = "MARITIME_TRANSPORT", schema = "best_Trip_db")
public class MaritimeTransport extends Transport implements Serializable {

	
	private int boatClass;
	
	

	public MaritimeTransport(Float transportCost, String nameCompany, Float transportRating, Float timeTravel,
			int boatClass) {
		super(transportCost, nameCompany, transportRating, timeTravel);
		this.boatClass = boatClass;
	}



	/**
	 * @return the boatClass
	 */
	public int getBoatClass() {
		return boatClass;
	}



	/**
	 * @param boatClass the boatClass to set
	 */
	public void setBoatClass(int boatClass) {
		this.boatClass = boatClass;
	}



	@Override
	public String toString() {
		return "MaritimeTransport [boatClass=" + boatClass + "]";
	}



	







	

	
	
}
