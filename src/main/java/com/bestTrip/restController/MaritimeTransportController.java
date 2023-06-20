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
import com.bestTrip.entities.MaritimeTransport;
import com.bestTrip.entities.Transport;
import com.bestTrip.services.interfaces.IMaritimeTransportService;

@RestController
@CrossOrigin
public class MaritimeTransportController {
	
	@Autowired 
	IMaritimeTransportService maritimeTransportService;
	
	//@RequestMapping(value = "maritimeTransports", method = RequestMethod.GET)
		@GetMapping("/maritimeTransports")
		public List<MaritimeTransport> findAll() {
			return maritimeTransportService.findAll();
		}

		//@RequestMapping(value = "maritimeTransports/{idMaritimeTransport}", method = RequestMethod.GET)
		@GetMapping("/maritimeTransports/{nameCompany}")
		public List<MaritimeTransport> findByNameCompany(@PathVariable("nameCompany") String nameCompany) {
			return maritimeTransportService.findByNameCompany(nameCompany);
		}
		
		
		/*public MaritimeTransport findOne(@PathVariable("idTransport") Long id) {
			return maritimeTransportService.findOne(id);
		}*/

		//@RequestMapping(value = "maritimeTransports", method = RequestMethod.POST)
		@PostMapping("/maritimeTransports")
		public MaritimeTransport saveMaritimeTransport(@RequestBody MaritimeTransport maritimeTransport) {
			return maritimeTransportService.save(maritimeTransport);
		}

		//@RequestMapping(value = "maritimeTransports/{idMaritimeTransport}", method = RequestMethod.DELETE)
		@DeleteMapping("/maritimeTransports/{idTransport}")
		public void deleteMaritimeTransport(@PathVariable("idTransport") Long id) {
			maritimeTransportService.delete(id);
		}

		//@RequestMapping(value = "maritimeTransports/{idMaritimeTransport}", method = RequestMethod.PUT)
		@PutMapping("/maritimeTransports/{idTransport}")
		public MaritimeTransport updateMaritimeTransport(@PathVariable("idTransport") Long id, @RequestBody MaritimeTransport maritimeTransport) {
			MaritimeTransport currentMaritimeTransport = maritimeTransportService.findOne(id);
			currentMaritimeTransport.setNameCompany(maritimeTransport.getNameCompany());
			currentMaritimeTransport.setIdTransport(maritimeTransport.getIdTransport());
			currentMaritimeTransport.setTimeTravel(maritimeTransport.getTimeTravel());
			currentMaritimeTransport.setTransportCost(maritimeTransport.getTransportCost());
			currentMaritimeTransport.setTransportRating(maritimeTransport.getTransportRating());
			currentMaritimeTransport.setDescription(maritimeTransport.getDescription());
			currentMaritimeTransport.setBoatClass(maritimeTransport.getBoatClass());
			return maritimeTransportService.save(currentMaritimeTransport);
		}


}
