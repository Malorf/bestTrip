package com.bestTrip.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bestTrip.entities.Restaurant;
import com.bestTrip.services.interfaces.IRestaurantService;

public class RestaurantController {
	
	@Autowired 
	IRestaurantService restaurantService;
	
	//@RequestMapping(value = "restaurants", method = RequestMethod.GET)
		@GetMapping("/restaurants")
		public List<Restaurant> findAll() {
			return restaurantService.findAll();
		}

		//@RequestMapping(value = "restaurants/{idRestaurant}", method = RequestMethod.GET)
		@GetMapping("/restaurants/{idRestaurant}")
		public Restaurant findOne(@PathVariable("idRestaurant") Long id) {
			return restaurantService.findOne(id);
		}

		//@RequestMapping(value = "restaurants", method = RequestMethod.POST)
		@PostMapping("/restaurants")
		public Restaurant saveRestaurant(@RequestBody Restaurant restaurant) {
			return restaurantService.save(restaurant);
		}

		//@RequestMapping(value = "restaurants/{idRestaurant}", method = RequestMethod.DELETE)
		@DeleteMapping("/restaurants/{idRestaurant}")
		public void deleteRestaurant(@PathVariable("idRestaurant") Long id) {
			restaurantService.delete(id);
		}

		//@RequestMapping(value = "restaurants/{idRestaurant}", method = RequestMethod.PUT)
		@PutMapping("/restaurants/{idRestaurant}")
		public Restaurant updateRestaurant(@PathVariable("idRestaurant") Long id, @RequestBody Restaurant restaurant) {
			Restaurant currentRestaurant = restaurantService.findOne(id);
			currentRestaurant.setAdress(restaurant.getAdress());
			currentRestaurant.setIdPlace(restaurant.getIdPlace());
			currentRestaurant.setPlaceCost(restaurant.getPlaceCost());
			currentRestaurant.setPlaceName(restaurant.getPlaceName());
			currentRestaurant.setPlaceRating(restaurant.getPlaceRating());
			currentRestaurant.setTakeAway(restaurant.isTakeAway());
		
			return restaurantService.save(currentRestaurant);
		}

}
