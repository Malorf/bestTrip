package com.bestTrip.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bestTrip.entities.Review;
import com.bestTrip.services.interfaces.IReviewService;

@RestController
@CrossOrigin
public class ReviewController {
	@Autowired 
	IReviewService reviewService;
	

		@GetMapping("/reviews")
		public List<Review> findAll() {
			return reviewService.findAll();
		}

		
		@GetMapping("/reviews/{idReview}")
		public Review findOne(@PathVariable("idReview") Long id) {
			return reviewService.findOne(id);
		}

		
		@PostMapping("/reviews")
		public Review saveReview(@RequestBody Review review) {
			return reviewService.save(review);
		}

	
		@DeleteMapping("/reviews/{idReview}")
		public void deleteReview(@PathVariable("idReview") Long id) {
			reviewService.delete(id);
		}

	
		@PutMapping("/reviews/{idReview}")
		public Review updateReview(@PathVariable("idReview") Long id, @RequestBody Review review) {
			Review currentReview = reviewService.findOne(id);
			currentReview.setComment(review.getComment());
			currentReview.setUserRating(review.getUserRating());
			currentReview.setReviewObjectId(review.getReviewObjectId());
			currentReview.setReviewObjectType(review.getReviewObjectType());
			return reviewService.save(currentReview);
		}

	}
	


