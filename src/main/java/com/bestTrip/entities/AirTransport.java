package com.bestTrip.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value ="AirTransport")
@Table(name = "AIR_TRANSPORT", schema = "best_Trip_db")
public class AirTransport extends Transport implements Serializable{

		private String airplaneClass;
		
		public AirTransport() {
			// TODO Auto-generated constructor stub
		}

		public AirTransport(Float transportCost, String nameCompany, Float transportRating, Float timeTravel,
				String airplaneClass) {
			super(transportCost, nameCompany, transportRating, timeTravel);
			this.airplaneClass = airplaneClass;
		}


		public String getAirplaceClass() {
			return airplaneClass;
		}


		public void setAirplaceClass(String airplaneClass) {
			this.airplaneClass = airplaneClass;
		}

		@Override
		public String toString() {
			return "AirTransport [airplaneClass=" + airplaneClass + "]";
		}


	

	
		
		
}
