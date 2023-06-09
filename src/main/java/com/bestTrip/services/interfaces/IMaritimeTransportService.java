package com.bestTrip.services.interfaces;

import java.util.List;


import com.bestTrip.entities.MaritimeTransport;
import com.bestTrip.entities.Transport;

public interface IMaritimeTransportService {
	
	List<MaritimeTransport> findAll();

	MaritimeTransport findOne(Long id);

	MaritimeTransport save(MaritimeTransport maritimeTransport);

	void delete(Long id);
	
	MaritimeTransport findByNameCompany(String nameCompany);
}
