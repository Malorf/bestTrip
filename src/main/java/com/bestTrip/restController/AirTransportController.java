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
import com.bestTrip.entities.Transport;
import com.bestTrip.services.interfaces.IAirTransportService;


@RestController
@CrossOrigin
public class AirTransportController {
	@Autowired 
	IAirTransportService airTransportService;
	
	//@RequestMapping(value = "airTransports", method = RequestMethod.GET)
		@GetMapping("/airTransports")
		public List<AirTransport> findAll() {
			return airTransportService.findAll();
		}

		//@RequestMapping(value = "airTransports/{idAirTransport}", method = RequestMethod.GET)
		@GetMapping("/airTransports/{nameCompany}")
		/*public AirTransport findOne(@PathVariable("idAirTransport") Long id) {
			return airTransportService.findOne(id);
		}*/
		public List<AirTransport> findByNameCompany(@PathVariable("nameCompany") String nameCompany) {
			return airTransportService.findByNameCompany(nameCompany);
		}

		//@RequestMapping(value = "airTransports", method = RequestMethod.POST)
		@PostMapping("/airTransports")
		public AirTransport saveAirTransport(@RequestBody AirTransport airTransport) {
			return airTransportService.save(airTransport);
		}

		//@RequestMapping(value = "airTransports/{idAirTransport}", method = RequestMethod.DELETE)
		@DeleteMapping("/airTransports/{idTransport}")
		public void deleteAirTransport(@PathVariable("idTransport") Long id) {
			airTransportService.delete(id);
		}

		//@RequestMapping(value = "airTransports/{idAirTransport}", method = RequestMethod.PUT)
		@PutMapping("/airTransports/{idTransport}")
		public AirTransport updateAirTransport(@PathVariable("idTransport") Long id, @RequestBody AirTransport airTransport) {
			AirTransport currentAirTransport = airTransportService.findOne(id);
			currentAirTransport.setNameCompany(airTransport.getNameCompany());
			currentAirTransport.setIdTransport(airTransport.getIdTransport());
			currentAirTransport.setTimeTravel(airTransport.getTimeTravel());
			currentAirTransport.setTransportCost(airTransport.getTransportCost());
			currentAirTransport.setTransportRating(airTransport.getTransportRating());
			currentAirTransport.setAirplaneClass(airTransport.getAirplaneClass());
			currentAirTransport.setDescription(airTransport.getDescription());
			
			return airTransportService.save(currentAirTransport);
		}

}
