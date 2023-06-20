package com.bestTrip.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestTrip.entities.TravelGuide;

@Repository
public interface TravelGuideRepository extends JpaRepository<TravelGuide, Long>{
	List<TravelGuide> findByCountryNameAndTotalCostAndGlobalRating (String countryName, float totalCost, float globalRating);

	
	
}