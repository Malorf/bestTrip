package com.bestTrip.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bestTrip.entities.Newsletter;
import com.bestTrip.repositories.NewsletterRepository;
import com.bestTrip.services.interfaces.INewsletterService;

@Service
public class NewsletterService implements INewsletterService {

	@Autowired
	NewsletterRepository newsletterRepository;
	
	@Override
	public List<Newsletter> findAll() {
		
		return newsletterRepository.findAll();
	}

	@Override
	public Newsletter findOne(Long id) {
		
		return newsletterRepository.findById(id).get();
	}

	@Override
	public Newsletter save(Newsletter newsletter) {
		
		return newsletterRepository.save(newsletter);
	}

	@Override
	public void delete(Long id) {
		newsletterRepository.deleteById(id);
		
	}
}
