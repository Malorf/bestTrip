package com.bestTrip.services.interfaces;

import java.util.List;

import com.bestTrip.entities.Experience;

public interface IExperienceService {
	
	List<Experience> findAll();

	Experience findOne(Long id);

	Experience save(Experience experience);

	void delete(Long id);

}
