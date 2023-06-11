package com.bestTrip.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.bestTrip.models.Adress;

@Entity
@DiscriminatorValue(value = "Restaurant")
@Table(name = "RESTAURANTS", schema = "best_Trip_db")
public class Restaurant extends Place implements Serializable{

		private boolean takeAway;
		
		public Restaurant() {
			// TODO Auto-generated constructor stub
		}

		

		public Restaurant(String placeName, Adress adress, Float placeRating, Float placeCost, boolean takeAway) {
			super(placeName, adress, placeRating, placeCost);
			this.takeAway = takeAway;
		}



		/**
		 * @return the takeAway
		 */
		public boolean isTakeAway() {
			return takeAway;
		}

		/**
		 * @param takeAway the takeAway to set
		 */
		public void setTakeAway(boolean takeAway) {
			this.takeAway = takeAway;
		}



		@Override
		public String toString() {
			return "Restaurant [takeAway=" + takeAway + "]";
		}
		
		
}
