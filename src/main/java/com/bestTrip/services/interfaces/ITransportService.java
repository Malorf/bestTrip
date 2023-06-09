package com.bestTrip.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bestTrip.entities.Transport;

@Service
public interface ITransportService {

	List<Transport> findAll();

	Transport findOne(Long id);

	Transport save(Transport transport);

	void delete(Long id);
	
	Transport findByNameCompany(String nameCompany);
	
}
