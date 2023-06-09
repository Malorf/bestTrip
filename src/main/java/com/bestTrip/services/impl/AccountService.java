package com.bestTrip.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestTrip.entities.Account;
import com.bestTrip.repositories.AccountRepository;
import com.bestTrip.services.interfaces.IAccountService;

@Service
public class AccountService implements IAccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account findOne(Long id) {
		return accountRepository.findById(id).get();
	}

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public void delete(Long id) {
		accountRepository.deleteById(id);
		
	}

	@Override
	public Account findbyUsername(String username) {
		return accountRepository.findByUsername(username);
	}

}
