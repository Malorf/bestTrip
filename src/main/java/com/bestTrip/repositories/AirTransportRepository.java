package com.bestTrip.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestTrip.entities.AirTransport;
import com.bestTrip.entities.Transport;


@Repository
public interface AirTransportRepository extends JpaRepository<AirTransport, Long>{
	
	List<AirTransport> findByNameCompany(String nameCompany);
}
