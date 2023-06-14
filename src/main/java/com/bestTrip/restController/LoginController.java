package com.bestTrip.restController;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestTrip.entities.Account;
import com.bestTrip.services.interfaces.IAccountService;

@RestController
@RequestMapping(value="/login")
public class LoginController {
	@Autowired
	IAccountService accountService;
	
	@CrossOrigin
	@RequestMapping(value="/account")
	public Account login(Principal principal)
	{
		return accountService.findbyUsername(principal.getName());
	}

}
