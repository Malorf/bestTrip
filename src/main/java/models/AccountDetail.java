package models;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bestTrip.entities.Account;

public class AccountDetail implements UserDetails{
	
	private Account account;
	Set<GrantedAuthority> authorities=null;
	
	public Account getAccount()
	{
		return account;
	}
	public void setAccount(Account account)
	{
		this.account=account;
	}
	public void setAuthorities(Set<GrantedAuthority> authorities)
	{
		 this.authorities = authorities;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return account.getPassword();
	}

	@Override
	public String getUsername() {
		return account.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
