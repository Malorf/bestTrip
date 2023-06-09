package com.bestTrip.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestTrip.entities.Restaurant;
import com.bestTrip.repositories.RestaurantRepository;
import com.bestTrip.services.interfaces.IRestaurantService;

@Service
public class RestaurantService implements IRestaurantService{

	@Autowired
	RestaurantRepository restaurantRepository; 
	
	
	@Override
	public List<Restaurant> findAll() {
		return restaurantRepository.findAll();
	}

	@Override
	public Restaurant findOne(Long id) {
		return restaurantRepository.findById(id).get();
	}

	@Override
	public Restaurant save(Restaurant restaurant) {
		return restaurantRepository.save(restaurant) ;
	}

	@Override
	public void delete(Long id) {
		restaurantRepository.deleteById(id);
		
	}

	@Override
	public Restaurant findByNamePlace(String namePlace) {
		return restaurantRepository.findByPlaceName(namePlace);
	}

}
