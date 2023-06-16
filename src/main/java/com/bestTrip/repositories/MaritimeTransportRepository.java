package com.bestTrip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestTrip.entities.AirTransport;
import com.bestTrip.entities.MaritimeTransport;

@Repository
public interface MaritimeTransportRepository extends JpaRepository<MaritimeTransport, Long>{

}


