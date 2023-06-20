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

import com.bestTrip.entities.Activity;
import com.bestTrip.entities.Place;
import com.bestTrip.services.interfaces.IActivityService;

@RestController
@CrossOrigin
public class ActivityController {
	@Autowired 
	IActivityService activityService;
	
	//@RequestMapping(value = "activitys", method = RequestMethod.GET)
		@GetMapping("/activities")
		public List<Activity> findAll() {
			return activityService.findAll();
		}

		//@RequestMapping(value = "activitys/{idActivity}", method = RequestMethod.GET)
		@GetMapping("/activities/{placeName}")
		public List<Activity> findByPlaceName(@PathVariable("placeName") String placeName) {
			return activityService.findByPlaceName(placeName);
		}
		
		/*public Activity findOne(@PathVariable("idActivity") Long id) {
			return activityService.findOne(id);
		}*/

		//@RequestMapping(value = "activitys", method = RequestMethod.POST)
		@PostMapping("/activities")
		public Activity saveActivity(@RequestBody Activity activity) {
			return activityService.save(activity);
		}

		//@RequestMapping(value = "activitys/{idActivity}", method = RequestMethod.DELETE)
		@DeleteMapping("/activities/{idPlace}")
		public void deleteActivity(@PathVariable("idPlace") Long id) {
			activityService.delete(id);
		}

		//@RequestMapping(value = "activitys/{idActivity}", method = RequestMethod.PUT)
		@PutMapping("/activities/{idPlace}")
		public Activity updateActivity(@PathVariable("idPlace") Long id, @RequestBody Activity activity) {
			Activity currentActivity = activityService.findOne(id);
			currentActivity.setAdress(activity.getAdress());
			currentActivity.setIdPlace(activity.getIdPlace());
			currentActivity.setPlaceCost(activity.getPlaceCost());
			currentActivity.setPlaceName(activity.getPlaceName());
			currentActivity.setPlaceRating(activity.getPlaceRating());
			currentActivity.setFree(activity.isFree());
			currentActivity.setDesciption(activity.getDesciption());
		
			return activityService.save(currentActivity);
		}
}
