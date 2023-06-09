package com.bestTrip.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bestTrip.services.impl.AppUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

		@Autowired
		private AppUserDetailsService appUserDetailsService;
		@Autowired
		private BCryptPasswordEncoder bCryptPasswordEncoder;
		
		public void configure(AuthenticationManagerBuilder auth) throws Exception
		{
			auth.userDetailsService(appUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
		}
		
		public void configure(HttpSecurity http) throws Exception
		{
			http
				.authorizeRequests()
				.anyRequest().authenticated()
				.and()
				.formLogin()
					.permitAll()
				.and()
				.logout()
					.logoutUrl("/logout")
					.permitAll()
				.and()
				.httpBasic()
				.and()
				.csrf().disable();
		}
}
