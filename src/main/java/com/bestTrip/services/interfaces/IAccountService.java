package com.bestTrip.services.interfaces;

import java.util.List;

import com.bestTrip.entities.Account;

public interface IAccountService {
	List<Account> findAll();
	
	Account findOne(Long id);
	Account save(Account account);
	void delete(Long id);
	Account findbyUsername(String username);
}
