package com.bestTrip.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestTrip.entities.TravelGuide;
import com.bestTrip.repositories.TravelGuideRepository;
import com.bestTrip.services.interfaces.ITravelGuideService;

@Service
public class TravelGuideService implements ITravelGuideService {
	@Autowired
	TravelGuideRepository travelGuideRepository;

	@Override
	public List<TravelGuide> findAll() {
		return travelGuideRepository.findAll();
	}

	@Override
	public TravelGuide findOne(Long id) {
		return travelGuideRepository.findById(id).get(); 
	}

	@Override
	public TravelGuide save(TravelGuide travelGuide) {
		return travelGuideRepository.save(travelGuide) ;
	}

	@Override
	public void delete(Long id) {
		travelGuideRepository.deleteById(id);
		
	}

}
