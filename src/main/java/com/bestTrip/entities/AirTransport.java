package com.bestTrip.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value ="AirTransport")
@Table(name = "AIRTRANSPORTS", schema = "best_Trip_db")
public class AirTransport extends Transport implements Serializable{

		private String airplaneClass;
		
		public AirTransport() {
			// TODO Auto-generated constructor stub
		}

		


	

		public AirTransport(Float transportCost, String nameCompany, Float transportRating, Float timeTravel,
				String description, List<TravelGuide> transportsTravelGuides, String airplaneClass) {
			super(transportCost, nameCompany, transportRating, timeTravel, description, transportsTravelGuides);
			this.airplaneClass = airplaneClass;
		}






		public String getAirplaneClass() {
			return airplaneClass;
		}






		public void setAirplaneClass(String airplaneClass) {
			this.airplaneClass = airplaneClass;
		}






		@Override
		public String toString() {
			return "AirTransport [airplaneClass=" + airplaneClass + "]";
		}




	

	
		
		
}
