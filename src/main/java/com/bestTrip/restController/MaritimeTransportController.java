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

import com.bestTrip.entities.MaritimeTransport;
import com.bestTrip.services.interfaces.IMaritimeTransportService;

@RestController
@CrossOrigin
public class MaritimeTransportController {
	
	@Autowired 
	IMaritimeTransportService maritimeTransportService;
	
	//@RequestMapping(value = "maritimeTransports", method = RequestMethod.GET)
		@GetMapping("/maritime_transport")
		public List<MaritimeTransport> findAll() {
			return maritimeTransportService.findAll();
		}

		//@RequestMapping(value = "maritimeTransports/{idMaritimeTransport}", method = RequestMethod.GET)
		@GetMapping("/maritime_transport/{idMaritimeTransport}")
		public MaritimeTransport findOne(@PathVariable("idMaritimeTransport") Long id) {
			return maritimeTransportService.findOne(id);
		}

		//@RequestMapping(value = "maritimeTransports", method = RequestMethod.POST)
		@PostMapping("/maritime_transport")
		public MaritimeTransport saveMaritimeTransport(@RequestBody MaritimeTransport maritimeTransport) {
			return maritimeTransportService.save(maritimeTransport);
		}

		//@RequestMapping(value = "maritimeTransports/{idMaritimeTransport}", method = RequestMethod.DELETE)
		@DeleteMapping("/maritime_transport/{idMaritimeTransport}")
		public void deleteMaritimeTransport(@PathVariable("idMaritimeTransport") Long id) {
			maritimeTransportService.delete(id);
		}

		//@RequestMapping(value = "maritimeTransports/{idMaritimeTransport}", method = RequestMethod.PUT)
		@PutMapping("/maritime_transport/{idMaritimeTransport}")
		public MaritimeTransport updateMaritimeTransport(@PathVariable("idMaritimeTransport") Long id, @RequestBody MaritimeTransport maritimeTransport) {
			MaritimeTransport currentMaritimeTransport = maritimeTransportService.findOne(id);
			currentMaritimeTransport.setNameCompany(maritimeTransport.getNameCompany());
			currentMaritimeTransport.setIdTransport(maritimeTransport.getIdTransport());
			currentMaritimeTransport.setTimeTravel(maritimeTransport.getTimeTravel());
			currentMaritimeTransport.setTransportCost(maritimeTransport.getTransportCost());
			currentMaritimeTransport.setTransportRating(maritimeTransport.getTransportRating());
		
			currentMaritimeTransport.setBoatClass(maritimeTransport.getBoatClass());
			
			return maritimeTransportService.save(currentMaritimeTransport);
		}


}
