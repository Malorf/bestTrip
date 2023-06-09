package com.bestTrip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestTrip.entities.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>{
	
	Activity findByPlaceName(String placeName);

}
