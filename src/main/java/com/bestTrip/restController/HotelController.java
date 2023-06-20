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

import com.bestTrip.entities.Hotel;
import com.bestTrip.entities.Place;
import com.bestTrip.services.interfaces.IHotelService;

@RestController
@CrossOrigin
public class HotelController {

	@Autowired 
	IHotelService hotelService;
	
	//@RequestMapping(value = "hotels", method = RequestMethod.GET)
		@GetMapping("/hotels")
		public List<Hotel> findAll() {
			return hotelService.findAll();
		}

		//@RequestMapping(value = "hotels/{idHotel}", method = RequestMethod.GET)
		@GetMapping("/hotels/{placeName}")
		public List<Hotel> findByPlaceName(@PathVariable("placeName") String placeName) {
			return hotelService.findByPlaceName(placeName);
		}
		/*public Hotel findOne(@PathVariable("idHotel") Long id) {
			return hotelService.findOne(id);
		}*/

		//@RequestMapping(value = "hotels", method = RequestMethod.POST)
		@PostMapping("/hotels")
		public Hotel saveHotel(@RequestBody Hotel hotel) {
			return hotelService.save(hotel);
		}

		//@RequestMapping(value = "hotels/{idHotel}", method = RequestMethod.DELETE)
		@DeleteMapping("/hotels/{idPlace}")
		public void deleteHotel(@PathVariable("idPlace") Long id) {
			hotelService.delete(id);
		}

		//@RequestMapping(value = "hotels/{idHotel}", method = RequestMethod.PUT)
		@PutMapping("/hotels/{idPlace}")
		public Hotel updateHotel(@PathVariable("idPlace") Long id, @RequestBody Hotel hotel) {
			Hotel currentHotel = hotelService.findOne(id);
			currentHotel.setAdress(hotel.getAdress());
			currentHotel.setIdPlace(hotel.getIdPlace());
			currentHotel.setPlaceCost(hotel.getPlaceCost());
			currentHotel.setPlaceName(hotel.getPlaceName());
			currentHotel.setPlaceRating(hotel.getPlaceRating());
			currentHotel.setStars(hotel.getStars());
			currentHotel.setDesciption(hotel.getDesciption());
		
			return hotelService.save(currentHotel);
		}
}
