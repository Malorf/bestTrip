package com.bestTrip.services.interfaces;

import java.util.List;

import com.bestTrip.entities.Restaurant;

public interface IRestaurantService {
	List<Restaurant> findAll();

	Restaurant findOne(Long id);

	Restaurant save(Restaurant restaurant);

	void delete(Long id);
	
	List<Restaurant> findByPlaceName(String placeName);
}
