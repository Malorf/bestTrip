package com.bestTrip.services.interfaces;

import java.util.List;

import com.bestTrip.entities.AirTransport;

public interface IAirTransportService {
	List<AirTransport> findAll();

	AirTransport findOne(Long id);

	AirTransport save(AirTransport airTransport);

	void delete(Long id);
	
	List<AirTransport> findByNameCompany(String nameCompany);
	
}
