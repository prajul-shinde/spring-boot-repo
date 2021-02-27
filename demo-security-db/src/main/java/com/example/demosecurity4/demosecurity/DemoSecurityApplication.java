package com.example.demosecurity4.demosecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demosecurity4.demosecurity.repository.UserRepository;

// 401 = unauthorized = authentication failed , you are not a valid user
// 403 = forbidden = valid user but doesn't have authority
//default api provided are /login and /logout
@SpringBootApplication
public class DemoSecurityApplication implements CommandLineRunner {

	@Autowired
	UserRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//
//		User user = new User("prajul", "$2a$10$LXNDdlVdFi8.jinIu7yIIOqIfhGTk.lvH.3M6..rd3RWUmgIPPZzS", true,
//				"admin:student");
//		User user1 = new User("onkar", "$2a$10$l8ZfoF.Skhhvl1E2hRADNuVJCim13Zgdiqy8jL/WYZ6yNkVH6aDHi", true, "student");
//		repo.save(user);
//		repo.save(user1);

	}

}
