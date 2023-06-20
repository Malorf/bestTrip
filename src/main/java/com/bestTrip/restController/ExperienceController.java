package com.bestTrip.restController;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.bestTrip.entities.Experience;


import com.bestTrip.services.interfaces.IExperienceService;


@RestController
@CrossOrigin
public class ExperienceController {

	@Autowired
	IExperienceService experienceService;

	// @RequestMapping(value = "experiences", method = RequestMethod.GET)
	@GetMapping("/experiences")
	public List<Experience> findAll() {
		return experienceService.findAll();
	}

	@GetMapping("/experiences/{date}")
	public List<Experience> findByUpdateExp(@PathVariable("date") @DateTimeFormat(pattern= "yyyy-MM-dd") Date date) {
		return experienceService.findByUpdateExp(date);
	}

	// @RequestMapping(value = "experiences/{idExperience}", method =
	// RequestMethod.GET)

	 /*@GetMapping("/experiences/{idExperience}") public Experience
	 findOne(@PathVariable("idExperience") Long id) { return
	 experienceService.findOne(id); }*/
	 

	// @RequestMapping(value = "experiences", method = RequestMethod.POST)
	
	 @PostMapping("/experiences") 
	 public Experience saveExperience(@RequestBody Experience experience) { 
		 return experienceService.save(experience); 
		 }
	 
	
	/*@PostMapping("/experiences")
	public String saveExperience(@RequestParam("urlTravelGuide") String urlTravelGuide,
			@RequestParam("videoExp") String videoExp, @RequestParam("description") String description,
			@RequestParam("updateExp") Date updateExp,
			 @RequestParam("accountExperience") Account accountExperience,
			@RequestParam("imageExp") MultipartFile imageExp) {
		try {
			Experience currentUser = new Experience();
			currentUser.setUrlTravelGuide(urlTravelGuide);
			currentUser.setUrlVideoExp(videoExp);
			currentUser.setDescription(description);
			currentUser.setUpdateExp(updateExp);
			currentUser.setAccount(accountExperience);

			currentUser.setImageExp(imageExp.getBytes());
			experienceService.save(currentUser);
			return "Success";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Error";
		}
	}*/

	// @RequestMapping(value = "experiences/{idExperience}", method =
	// RequestMethod.DELETE)
	@DeleteMapping("/experiences/{idExperience}")
	public void deleteExperience(@PathVariable("idExperience") Long id) {
		experienceService.delete(id);
	}

	// @RequestMapping(value = "experiences/{idExperience}", method =
	// RequestMethod.PUT)
	@PutMapping("/experiences/{idExperience}")
	public Experience updateExperience(@PathVariable("idExperience") Long id, @RequestBody Experience experience) {
		Experience currentExperience = experienceService.findOne(id);
		currentExperience.setUrlTravelGuide(experience.getUrlTravelGuide());
		currentExperience.setUrlVideoExp(experience.getUrlVideoExp());
		currentExperience.setDescription(experience.getDescription());
		currentExperience.setUpdateExp(experience.getUpdateExp());
		currentExperience.setStatusExp(experience.getStatusExp());
		
		return experienceService.save(currentExperience);
	}

}
