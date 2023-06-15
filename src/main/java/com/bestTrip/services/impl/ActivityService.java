package com.bestTrip.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestTrip.entities.Activity;
import com.bestTrip.entities.Place;
import com.bestTrip.entities.Activity;
import com.bestTrip.repositories.ActivityRepository;
import com.bestTrip.services.interfaces.IActivityService;

@Service
public class ActivityService implements IActivityService {

	@Autowired
	ActivityRepository activityRepository; 
	
	
	@Override
	public List<Activity> findAll() {
		return activityRepository.findAll();
	}

	@Override
	public Activity findOne(Long id) {
		return activityRepository.findById(id).get();
	}

	@Override
	public Activity save(Activity activity) {
		return activityRepository.save(activity) ;
	}

	@Override
	public void delete(Long id) {
		activityRepository.deleteById(id);
		
	}

	@Override
	public List<Activity> findByPlaceName(String placeName) {

		return activityRepository.findByPlaceName(placeName);
	}



}
