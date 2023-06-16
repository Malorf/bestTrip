package com.bestTrip.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestTrip.entities.MaritimeTransport;
import com.bestTrip.repositories.MaritimeTransportRepository;
import com.bestTrip.services.interfaces.IMaritimeTransportService;

@Service
public class MaritimeTransportService implements IMaritimeTransportService{
	
	@Autowired
	MaritimeTransportRepository maritimeTransportRepository; 
	
	
	@Override
	public List<MaritimeTransport> findAll() {
		return maritimeTransportRepository.findAll();
	}

	@Override
	public MaritimeTransport findOne(Long id) {
		return maritimeTransportRepository.findById(id).get();
	}

	@Override
	public MaritimeTransport save(MaritimeTransport maritimeTransport) {
		return maritimeTransportRepository.save(maritimeTransport) ;
	}

	@Override
	public void delete(Long id) {
		maritimeTransportRepository.deleteById(id);
		
	}





}
