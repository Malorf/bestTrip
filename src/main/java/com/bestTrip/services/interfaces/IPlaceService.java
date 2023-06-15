package com.bestTrip.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bestTrip.entities.Place;

@Service
public interface IPlaceService {

	List<Place> findAll();

	Place findOne(Long id);

	Place save(Place place);

	void delete(Long id);
	
	List<Place> findByPlaceName(String placeName);
}

