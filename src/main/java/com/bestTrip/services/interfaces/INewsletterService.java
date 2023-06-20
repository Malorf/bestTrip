package com.bestTrip.services.interfaces;

import java.util.Date;
import java.util.List;

import com.bestTrip.entities.Newsletter;

public interface INewsletterService {

	List<Newsletter> findAll();

	Newsletter findOne(Long id);

	Newsletter save(Newsletter newsletter);

	void delete(Long id);
	
	List<Newsletter> findByPublicationDate(Date publicationDate);
}
