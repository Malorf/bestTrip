package com.bestTrip.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bestTrip.entities.Account;
import com.bestTrip.entities.Role;
import com.bestTrip.models.AccountDetail;
import com.bestTrip.services.interfaces.IAccountService;

@Service
public class AppUserDetailsService implements UserDetailsService{

	@Autowired
	IAccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account=accountService.findbyUsername(username);
		Set<Role> roles=account.getRoles();
		Set<GrantedAuthority> authorities=new HashSet<GrantedAuthority>();
		for (Role role:roles)
		{
			authorities.add(new SimpleGrantedAuthority(role.getNameRole()));
		}
		AccountDetail accountDetail=new AccountDetail();
		accountDetail.setAccount(account);
		accountDetail.setAuthorities(authorities);
		return accountDetail;
		
	}
	
}
