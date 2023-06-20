package com.bestTrip.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestTrip.entities.Transport;
import com.bestTrip.repositories.TransportRepository;
import com.bestTrip.services.interfaces.ITransportService;

@Service
public class TransportService implements ITransportService{

	@Autowired
	TransportRepository transportRepository; 
	
	
	@Override
	public List<Transport> findAll() {
		return transportRepository.findAll();
	}

	@Override
	public Transport findOne(Long id) {
		return transportRepository.findById(id).get();
	}

	@Override
	public Transport save(Transport transport) {
		return transportRepository.save(transport) ;
	}

	@Override
	public void delete(Long id) {
		transportRepository.deleteById(id);
		
	}

	@Override
	public List<Transport> findByNameCompany(String nameCompany) {
		// TODO Auto-generated method stub
		return transportRepository.findByNameCompany(nameCompany);
	}


}
