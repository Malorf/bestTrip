package com.bestTrip.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestTrip.entities.Newsletter;

@Repository
public interface NewsletterRepository extends JpaRepository<Newsletter, Long>{
	
	List<Newsletter> findByPublicationDate(Date publicationDate);

}
