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

import com.bestTrip.entities.TravelGuide;
import com.bestTrip.services.interfaces.ITravelGuideService;

@RestController
@CrossOrigin
public class TravelGuideController {
	@Autowired 
	ITravelGuideService travelGuideService;
	

	
		@GetMapping("/travelGuides")
		public List<TravelGuide> findAll() {
			return travelGuideService.findAll();
		}

		
		@GetMapping("/travelGuides/{idTravelGuide}")
		public TravelGuide findOne(@PathVariable("idTravelGuide") Long id) {
			return travelGuideService.findOne(id);
		}

		
		@PostMapping("/travelGuides")
		public TravelGuide saveTravelGuide(@RequestBody TravelGuide travelGuide) {
			return travelGuideService.save(travelGuide);
		}

		
		@DeleteMapping("/travelGuides/{idTravelGuide}")
		public void deleteTravelGuide(@PathVariable("idTravelGuide") Long id) {
			travelGuideService.delete(id);
		}

		
		@PutMapping("/travelGuides/{idTravelGuide}")
		public TravelGuide updateTravelGuide(@PathVariable("idTravelGuide") Long id, @RequestBody TravelGuide travelGuide) {
			TravelGuide currentTravelGuide = travelGuideService.findOne(id);
			currentTravelGuide.setGuideName(travelGuide.getGuideName());
			currentTravelGuide.setGlobalRating(travelGuide.getGlobalRating());
			currentTravelGuide.setCountryName(travelGuide.getCountryName());
			currentTravelGuide.setTotalCost(travelGuide.getTotalCost());
			currentTravelGuide.setStatusTravelGuide(travelGuide.getStatusTravelGuide());
			currentTravelGuide.setUpdateTravelGuide(travelGuide.getUpdateTravelGuide());
			return travelGuideService.save(currentTravelGuide);
		}

	}
	
