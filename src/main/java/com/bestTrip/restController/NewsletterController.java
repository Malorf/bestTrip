package com.bestTrip.restController;


import java.net.URL;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bestTrip.entities.Newsletter;
import com.bestTrip.services.impl.NewsletterService;
import com.bestTrip.services.interfaces.INewsletterService;

@RestController
@CrossOrigin
public class NewsletterController {
	
	@Autowired
	INewsletterService newsletterService;
	
	//@RequestMapping(value = "newsletters", method = RequestMethod.GET)
			@GetMapping("/newsletters")
			public List<Newsletter> findAll() {
				return newsletterService.findAll();
			}

			/*@RequestMapping(value = "newsletters/{idNewsletter}", method = RequestMethod.GET)
			@GetMapping("/newsletters/{idNewsletter}")
			public Newsletter findOne(@PathVariable("idNewsletter") Long id) {
				return newsletterService.findOne(id);
			}*/
			
			@GetMapping("/newsletters/{publicationDate}")
			public List<Newsletter> findByPublicationDate(@PathVariable(name="publicationDate") @DateTimeFormat(pattern= "yyyy-MM-dd")  Date publicationDate) {
			return newsletterService.findByPublicationDate(publicationDate);
			}  
			
			
			@PostMapping("/newsletters")
			public Newsletter saveNewsletter(@RequestBody Newsletter newsletter) {
				return newsletterService.save(newsletter);
			}
			
			/*@PostMapping("/newsletters")
			public String saveNewsletter(@RequestParam("publicationDate") Date publicationDate,@RequestParam("favoriteTripOfTheMonth") URL favoriteTripOfTheMonth, 
					@RequestParam("imageNewsletter") MultipartFile imageNewsletter) {
				try {
					Newsletter currentUser=new Newsletter();
					currentUser.setPublicationDate(publicationDate);
					currentUser.setFavoriteTripOfTheMonth(favoriteTripOfTheMonth);
					currentUser.setImageNewsletter(imageNewsletter.getBytes());
					newsletterService.save(currentUser);
					return "Success";
				}catch(Exception ex) {
					ex.printStackTrace();
					return "Error";
				}
			}*/

			//@RequestMapping(value = "newsletters/{idNewsletter}", method = RequestMethod.DELETE)
			@DeleteMapping("/newsletters/{idNewsletter}")
			public void deleteNewsletter(@PathVariable("idNewsletter") Long id) {
				newsletterService.delete(id);
			}

			//@RequestMapping(value = "newsletters/{idNewsletter}", method = RequestMethod.PUT)
			@PutMapping("/newsletters/{idNewsletter}")
			public Newsletter updateNewsletter(@PathVariable("idNewsletter") Long id, @RequestBody Newsletter newsletter) {
				Newsletter currentNewsletter = newsletterService.findOne(id);
				currentNewsletter.setPublicationDate(newsletter.getPublicationDate());
				currentNewsletter.setFavoriteTripOfTheMonth(newsletter.getFavoriteTripOfTheMonth());
				currentNewsletter.setImageNewsletter(newsletter.getImageNewsletter());
						
				return newsletterService.save(currentNewsletter);
			}

}
