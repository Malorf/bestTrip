package com.bestTrip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestTrip.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository <Account, Long> {
	
	Account findByUsername(String username);

}
