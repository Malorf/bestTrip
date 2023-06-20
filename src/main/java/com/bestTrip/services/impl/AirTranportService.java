package com.bestTrip.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestTrip.entities.AirTransport;
import com.bestTrip.repositories.AirTransportRepository;
import com.bestTrip.services.interfaces.IAirTransportService;

@Service
public class AirTranportService implements IAirTransportService{

	@Autowired
	AirTransportRepository airTransportRepository; 
	
	
	@Override
	public List<AirTransport> findAll() {
		return airTransportRepository.findAll();
	}

	@Override
	public AirTransport findOne(Long id) {
		return airTransportRepository.findById(id).get();
	}

	@Override
	public AirTransport save(AirTransport airTransport) {
		return airTransportRepository.save(airTransport) ;
	}

	@Override
	public void delete(Long id) {
		airTransportRepository.deleteById(id);
		
	}

	@Override
	public List<AirTransport> findByNameCompany(String nameCompany) {
		// TODO Auto-generated method stub
		return airTransportRepository.findByNameCompany(nameCompany);
	}


	
	
}
