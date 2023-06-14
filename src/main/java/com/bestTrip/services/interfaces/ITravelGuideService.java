package com.bestTrip.services.interfaces;

import java.util.List;

import com.bestTrip.entities.TravelGuide;


public interface ITravelGuideService {
	List<TravelGuide> findAll();

	TravelGuide findOne(Long id);

	TravelGuide save(TravelGuide travelGuide);

	void delete(Long id);

	List<TravelGuide> findByCountryName (String countryName);
	List<TravelGuide> findByTotalCost (float totalCost);
	List<TravelGuide> findByGlobalRating (float globalRating);
	
}
