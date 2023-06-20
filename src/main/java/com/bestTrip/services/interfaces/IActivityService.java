package com.bestTrip.services.interfaces;

import java.util.List;

import com.bestTrip.entities.Activity;
import com.bestTrip.entities.Hotel;


public interface IActivityService {

	List<Activity> findAll();

	Activity findOne(Long id);

	Activity save(Activity activity);

	void delete(Long id);
	
	List<Activity> findByPlaceName(String placeName);
	
}
