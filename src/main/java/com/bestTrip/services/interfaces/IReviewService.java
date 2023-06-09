package com.bestTrip.services.interfaces;

import java.util.List;

import com.bestTrip.entities.Review;



public interface IReviewService {
	List<Review> findAll();

	Review findOne(Long id);

	Review save(Review review);

	void delete(Long id);
	
}

