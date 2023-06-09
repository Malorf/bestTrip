package com.bestTrip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestTrip.entities.Activity;
import com.bestTrip.entities.Place;


@Repository
public interface PlaceRepository extends JpaRepository<Place, Long>{

	Place findByPlaceName(String placeName);
}
