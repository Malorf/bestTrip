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

import com.bestTrip.entities.Place;
import com.bestTrip.services.interfaces.IPlaceService;

@RestController
@CrossOrigin
public class PlaceController {
	@Autowired 
	IPlaceService placeService;
	
	//@RequestMapping(value = "places", method = RequestMethod.GET)
		@GetMapping("/places")
		public List<Place> findAll() {
			return placeService.findAll();
		}

		//@RequestMapping(value = "places/{idPlace}", method = RequestMethod.GET)
		@GetMapping("/places/{idPlace}")
		public Place findOne(@PathVariable("idPlace") Long id) {
			return placeService.findOne(id);
		}

		//@RequestMapping(value = "places", method = RequestMethod.POST)
		@PostMapping("/places")
		public Place savePlace(@RequestBody Place place) {
			return placeService.save(place);
		}

		//@RequestMapping(value = "places/{idPlace}", method = RequestMethod.DELETE)
		@DeleteMapping("/places/{idPlace}")
		public void deletePlace(@PathVariable("idPlace") Long id) {
			placeService.delete(id);
		}

		//@RequestMapping(value = "places/{idPlace}", method = RequestMethod.PUT)
		@PutMapping("/places/{idPlace}")
		public Place updatePlace(@PathVariable("idPlace") Long id, @RequestBody Place place) {
			Place currentPlace = placeService.findOne(id);
			currentPlace.setAdress(place.getAdress());
			currentPlace.setIdPlace(place.getIdPlace());
			currentPlace.setPlaceCost(place.getPlaceCost());
			currentPlace.setPlaceName(place.getPlaceName());
			currentPlace.setPlaceRating(place.getPlaceRating());
			return placeService.save(currentPlace);
		}

}
