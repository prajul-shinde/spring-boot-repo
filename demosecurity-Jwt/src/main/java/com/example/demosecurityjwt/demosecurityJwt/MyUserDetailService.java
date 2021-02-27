package com.example.demosecurityjwt.demosecurityJwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserServiceRepository repository;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

		return repository.findByUserName(s);
	}
}