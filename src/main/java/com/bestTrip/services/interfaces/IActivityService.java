package com.bestTrip.services.interfaces;

import java.util.List;

import com.bestTrip.entities.Activity;

public interface IActivityService {

	List<Activity> findAll();

	Activity findOne(Long id);

	Activity save(Activity activity);

	void delete(Long id);
	
	Activity findByNamePlace(String namePlace);
	
}
