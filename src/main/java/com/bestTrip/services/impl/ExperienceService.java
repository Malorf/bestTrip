package com.bestTrip.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestTrip.entities.Experience;
import com.bestTrip.repositories.ExperienceRepository;
import com.bestTrip.services.interfaces.IExperienceService;

@Service
public class ExperienceService implements IExperienceService {

	@Autowired
	ExperienceRepository experienceRepository;
	
	@Override
	public List<Experience> findAll() {
		
		return experienceRepository.findAll();
	}

	@Override
	public Experience findOne(Long id) {
		
		return experienceRepository.findById(id).get();
	}

	@Override
	public Experience save(Experience experience) {
		
		return experienceRepository.save(experience);
	}

	@Override
	public void delete(Long id) {
		experienceRepository.deleteById(id);
		
	}

	@Override
	public List<Experience> findByUpdateExp(Date date) {
		
		return experienceRepository.findByUpdateExp(date);
	}

}
