package com.bestTrip.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("AirTransport")
@Table(name = "AIR_TRANPORT", schema = "best_Trip_db")
public class AirTransport extends Transport implements Serializable{

		private String airplaceClass;
		
		public AirTransport() {
			// TODO Auto-generated constructor stub
		}

		public AirTransport(Float transportCost, String nameCompany, Float transportRating, Float timeTravel,
				String airplaceClass) {
			super(transportCost, nameCompany, transportRating, timeTravel);
			this.airplaceClass = airplaceClass;
		}

		/**
		 * @return the airplaceClass
		 */
		public String getAirplaceClass() {
			return airplaceClass;
		}

		/**
		 * @param airplaceClass the airplaceClass to set
		 */
		public void setAirplaceClass(String airplaceClass) {
			this.airplaceClass = airplaceClass;
		}

		@Override
		public String toString() {
			return "AirTransport [airplaceClass=" + airplaceClass + "]";
		}


	

	
		
		
}
