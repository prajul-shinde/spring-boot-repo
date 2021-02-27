package com.example.demosecurity4.demosecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demosecurity4.demosecurity.service.MyUserDetailsService;

@EnableWebSecurity
public class FooBarConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MyUserDetailsService service;

	// this is for authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service);
	}

	// this is for authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/admin/**").hasAuthority("admin")
				.antMatchers("/student/**").hasAnyAuthority("student", "admin").antMatchers("/signup/**")
				.hasAuthority("admin").and().formLogin();
	}

	@Bean
	public PasswordEncoder passWordEncode() {
		return new BCryptPasswordEncoder();
	}
}
