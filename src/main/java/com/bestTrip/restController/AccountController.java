package com.bestTrip.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bestTrip.entities.Account;
import com.bestTrip.services.interfaces.IAccountService;

@RestController
public class AccountController {
	@Autowired
	IAccountService accountService;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="accounts", method=RequestMethod.GET)
	public List<Account> findAll()
	{
		return accountService.findAll();
	}
	@RequestMapping(value="accounts/{id}", method =RequestMethod.GET)
	public Account findOne(@PathVariable("id")Long id)
	{
		return accountService.findOne(id);
	}
	@RequestMapping(value="accounts", method=RequestMethod.POST)
	public Account saveAccount(@RequestBody Account account)
	{
		Account currentAccount = new Account();
		currentAccount.seteMail(account.geteMail());
		currentAccount.setImageAccount(account.getImageAccount());
		currentAccount.setUsername(account.getUsername());
		currentAccount.setPassword(passwordEncoder.encode(account.getPassword()));
		currentAccount.setRoles(account.getRoles());
		currentAccount.setProfileName(account.getProfileName());
		currentAccount.setNumberOfExepriencesShared(account.getNumberOfExepriencesShared());
		currentAccount.setNumberOfGuideContributions(account.getNumberOfGuideContributions());
		currentAccount.setSub(account.isSub());
		return accountService.save(currentAccount);
	}
	@RequestMapping(value="accounts/{id}", method=RequestMethod.DELETE)
	public void deleteAccount(@PathVariable("id")Long id)
	{
		accountService.delete(id);
	}
	@RequestMapping(value="accounts/{id}", method=RequestMethod.PUT)
	public Account updateAccount(@PathVariable("id")Long id, @RequestBody Account account)
	{
		Account currentAccount = accountService.findOne(id);
		currentAccount.seteMail(account.geteMail());
		currentAccount.setUsername(account.getUsername());
		currentAccount.setPassword(account.getPassword());
		currentAccount.setRoles(account.getRoles());
		currentAccount.setProfileName(account.getProfileName());
		currentAccount.setSub(account.isSub());
		return accountService.save(currentAccount);
	}
}
