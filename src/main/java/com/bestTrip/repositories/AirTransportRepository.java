package com.bestTrip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestTrip.entities.AirTransport;


@Repository
public interface AirTransportRepository extends JpaRepository<AirTransport, Long>{
	
	AirTransport findByNameCompany (String nameCompany);
}
