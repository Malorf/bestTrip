package com.bestTrip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestTrip.entities.TravelGuide;

@Repository
public interface TravelGuideRepository extends JpaRepository<TravelGuide, Long>{

}
