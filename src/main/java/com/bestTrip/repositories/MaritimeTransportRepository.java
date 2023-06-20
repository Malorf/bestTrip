package com.bestTrip.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestTrip.entities.AirTransport;
import com.bestTrip.entities.Hotel;
import com.bestTrip.entities.MaritimeTransport;

@Repository
public interface MaritimeTransportRepository extends JpaRepository<MaritimeTransport, Long>{

	List<MaritimeTransport> findByNameCompany(String nameCompany);
}


