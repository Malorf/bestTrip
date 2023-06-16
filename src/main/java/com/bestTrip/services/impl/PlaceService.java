package com.bestTrip.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestTrip.entities.Place;
import com.bestTrip.repositories.PlaceRepository;
import com.bestTrip.services.interfaces.IPlaceService;



@Service
public class PlaceService implements IPlaceService{
	
	@Autowired
	PlaceRepository placeRepository; 
	
	
	@Override
	public List<Place> findAll() {
		return placeRepository.findAll();
	}

	@Override
	public Place findOne(Long id) {
		return placeRepository.findById(id).get();
	}

	@Override
	public Place save(Place place) {
		return placeRepository.save(place) ;
	}

	@Override
	public void delete(Long id) {
		placeRepository.deleteById(id);
		
	}

	

	@Override
	public List<Place> findByPlaceName(String placeName) {

		return placeRepository.findByPlaceName(placeName);
	}
	
}
