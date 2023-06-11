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

import com.bestTrip.entities.AirTransport;
import com.bestTrip.services.interfaces.IAirTransportService;


@RestController
@CrossOrigin
public class AirTransportController {
	@Autowired 
	IAirTransportService airTransportService;
	
	//@RequestMapping(value = "airTransports", method = RequestMethod.GET)
		@GetMapping("/air_transport")
		public List<AirTransport> findAll() {
			return airTransportService.findAll();
		}

		//@RequestMapping(value = "airTransports/{idAirTransport}", method = RequestMethod.GET)
		@GetMapping("/air_transport/{idAirTransport}")
		public AirTransport findOne(@PathVariable("idAirTransport") Long id) {
			return airTransportService.findOne(id);
		}

		//@RequestMapping(value = "airTransports", method = RequestMethod.POST)
		@PostMapping("/air_transport")
		public AirTransport saveAirTransport(@RequestBody AirTransport airTransport) {
			return airTransportService.save(airTransport);
		}

		//@RequestMapping(value = "airTransports/{idAirTransport}", method = RequestMethod.DELETE)
		@DeleteMapping("/air_transport/{idAirTransport}")
		public void deleteAirTransport(@PathVariable("idAirTransport") Long id) {
			airTransportService.delete(id);
		}

		//@RequestMapping(value = "airTransports/{idAirTransport}", method = RequestMethod.PUT)
		@PutMapping("/air_transport/{idAirTransport}")
		public AirTransport updateAirTransport(@PathVariable("idAirTransport") Long id, @RequestBody AirTransport airTransport) {
			AirTransport currentAirTransport = airTransportService.findOne(id);
			currentAirTransport.setNameCompany(airTransport.getNameCompany());
			currentAirTransport.setIdTransport(airTransport.getIdTransport());
			currentAirTransport.setTimeTravel(airTransport.getTimeTravel());
			currentAirTransport.setTransportCost(airTransport.getTransportCost());
			currentAirTransport.setTransportRating(airTransport.getTransportRating());
		
			currentAirTransport.setAirplaceClass(airTransport.getAirplaceClass());
			
			return airTransportService.save(currentAirTransport);
		}

}
