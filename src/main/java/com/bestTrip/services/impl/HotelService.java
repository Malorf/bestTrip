package com.bestTrip.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestTrip.entities.Hotel;
import com.bestTrip.repositories.HotelRepository;
import com.bestTrip.services.interfaces.IHotelService;

@Service
public class HotelService implements IHotelService{

	@Autowired
	HotelRepository hotelRepository; 
	
	
	@Override
	public List<Hotel> findAll() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel findOne(Long id) {
		return hotelRepository.findById(id).get();
	}

	@Override
	public Hotel save(Hotel hotel) {
		return hotelRepository.save(hotel) ;
	}

	@Override
	public void delete(Long id) {
		hotelRepository.deleteById(id);
		
	}

	@Override
	public Hotel findByNamePlace(String namePlace) {
		return hotelRepository.findByPlaceName(namePlace);
	}

}
