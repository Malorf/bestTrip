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

import com.bestTrip.entities.Restaurant;
import com.bestTrip.entities.Transport;
import com.bestTrip.services.interfaces.ITransportService;


@RestController
@CrossOrigin
public class TransportController {
	
	@Autowired 
	ITransportService transportService;
	
	//@RequestMapping(value = "transports", method = RequestMethod.GET)
		@GetMapping("/transports")
		public List<Transport> findAll() {
			return transportService.findAll();
		}

		//@RequestMapping(value = "transports/{idTransport}", method = RequestMethod.GET)
		@GetMapping("/transports/{nameCompany}")
		/*public Transport findOne(@PathVariable("idTransport") Long idTransport) {
			return transportService.findOne(idTransport);
		}*/
		public List<Transport> findByNameCompany(@PathVariable("nameCompany") String nameCompany) {
			return transportService.findByNameCompany(nameCompany);
		}

		//@RequestMapping(value = "transports", method = RequestMethod.POST)
		@PostMapping("/transports")
		public Transport saveTransport(@RequestBody Transport transport) {
			return transportService.save(transport);
		}

		//@RequestMapping(value = "transports/{idTransport}", method = RequestMethod.DELETE)
		@DeleteMapping("/transports/{idTransport}")
		public void deleteTransport(@PathVariable("idTransport") Long idTransport) {
			transportService.delete(idTransport);
		}

		//@RequestMapping(value = "transports/{idTransport}", method = RequestMethod.PUT)
		@PutMapping("/transports/{idTransport}")
		public Transport updateTransport(@PathVariable("idTransport") Long idTransport, @RequestBody Transport transport) {
			Transport currentTransport = transportService.findOne(idTransport);
			currentTransport.setNameCompany(transport.getNameCompany());
			currentTransport.setIdTransport(transport.getIdTransport());
			currentTransport.setTransportCost(transport.getTransportCost());
			currentTransport.setTransportRating(transport.getTransportRating());
			currentTransport.setTimeTravel(transport.getTimeTravel());
			currentTransport.setDescription(transport.getDescription());
			return transportService.save(currentTransport);
		}

}
