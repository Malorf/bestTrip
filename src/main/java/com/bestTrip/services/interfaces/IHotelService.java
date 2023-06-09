package com.bestTrip.services.interfaces;

import java.util.List;

import com.bestTrip.entities.Hotel;

public interface IHotelService {

	List<Hotel> findAll();

	Hotel findOne(Long id);

	Hotel save(Hotel hotel);

	void delete(Long id);
	
	Hotel findByNamePlace(String namePlace);
	
}
