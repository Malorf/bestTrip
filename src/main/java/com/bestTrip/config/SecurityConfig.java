package com.bestTrip.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.bestTrip.services.impl.AppUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

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
				.anyRequest().permitAll()
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
		@Bean
		public FilterRegistrationBean simpleCorsFilter() {
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			CorsConfiguration config = new CorsConfiguration();

			config.setAllowCredentials(true);
			config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
			config.setAllowedMethods(Collections.singletonList("*")); 
			config.setAllowedHeaders(Collections.singletonList("*"));

			source.registerCorsConfiguration("/**", config);

			FilterRegistrationBean bean = new FilterRegistrationBean (new CorsFilter(source));
			bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
			return bean;
		}

}
