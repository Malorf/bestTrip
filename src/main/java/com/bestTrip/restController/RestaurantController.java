package com.bestTrip.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bestTrip.entities.Place;
import com.bestTrip.entities.Restaurant;
import com.bestTrip.services.interfaces.IRestaurantService;

@RestController
@CrossOrigin
public class RestaurantController {
	
	@Autowired 
	IRestaurantService restaurantService;
	
	//@RequestMapping(value = "restaurants", method = RequestMethod.GET)
		@GetMapping("/restaurants")
		public List<Restaurant> findAll() {
			return restaurantService.findAll();
		}

		//@RequestMapping(value = "restaurants/{idRestaurant}", method = RequestMethod.GET)
		@GetMapping("/restaurants/{placeName}")
		
		public List<Restaurant> findByPlaceName(@PathVariable("placeName") String placeName) {
			return restaurantService.findByPlaceName(placeName);
		}
		/*public Restaurant findOne(@PathVariable("idRestaurant") Long id) {
			return restaurantService.findOne(id);
		}*/

		//@RequestMapping(value = "restaurants", method = RequestMethod.POST)
		@PostMapping("/restaurants")
		public Restaurant saveRestaurant(@RequestBody Restaurant restaurant) {
			return restaurantService.save(restaurant);
		}

		//@RequestMapping(value = "restaurants/{idRestaurant}", method = RequestMethod.DELETE)
		@DeleteMapping("/restaurants/{idPlace}")
		public void deleteRestaurant(@PathVariable("idPlace") Long id) {
			restaurantService.delete(id);
		}

		//@RequestMapping(value = "restaurants/{idRestaurant}", method = RequestMethod.PUT)
		@PutMapping("/restaurants/{idPlace}")
		public Restaurant updateRestaurant(@PathVariable("idPlace") Long id, @RequestBody Restaurant restaurant) {
			Restaurant currentRestaurant = restaurantService.findOne(id);
			currentRestaurant.setAdress(restaurant.getAdress());
			currentRestaurant.setIdPlace(restaurant.getIdPlace());
			currentRestaurant.setPlaceCost(restaurant.getPlaceCost());
			currentRestaurant.setPlaceName(restaurant.getPlaceName());
			currentRestaurant.setPlaceRating(restaurant.getPlaceRating());
			currentRestaurant.setDesciption(restaurant.getDesciption());
		
			return restaurantService.save(currentRestaurant);
		}

}
