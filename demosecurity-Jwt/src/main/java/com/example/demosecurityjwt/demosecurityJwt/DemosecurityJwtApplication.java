package com.example.demosecurityjwt.demosecurityJwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemosecurityJwtApplication implements CommandLineRunner {

	@Autowired
	private UserServiceRepository userServiceRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemosecurityJwtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userServiceRepository.save(new MyUserDetails("prajul", "prajul1234", true, "admin:student"));
		userServiceRepository.save(new MyUserDetails("onkar", "onkar1234", true, "student"));
	}

}
