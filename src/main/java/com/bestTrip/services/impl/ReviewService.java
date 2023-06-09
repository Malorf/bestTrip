package com.bestTrip.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestTrip.entities.Review;
import com.bestTrip.repositories.ReviewRepository;
import com.bestTrip.services.interfaces.IReviewService;

@Service
public class ReviewService implements IReviewService{
	@Autowired
	ReviewRepository reviewRepository; 
	
	
	@Override
	public List<Review> findAll() {
		return reviewRepository.findAll();
	}

	@Override
	public Review findOne(Long id) {
		return reviewRepository.findById(id).get();
	}

	@Override
	public Review save(Review review) {
		return reviewRepository.save(review) ;
	}

	@Override
	public void delete(Long id) {
		reviewRepository.deleteById(id);
		
	}

}
