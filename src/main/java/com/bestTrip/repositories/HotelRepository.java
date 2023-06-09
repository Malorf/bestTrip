package com.bestTrip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestTrip.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{

	Hotel findByPlaceName(String placeName);
}
