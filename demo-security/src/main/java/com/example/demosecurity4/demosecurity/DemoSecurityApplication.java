package com.example.demosecurity4.demosecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 401 = unauthorized = authentication failed , you are not a valid user
// 403 = forbidden = valid user but doesn't have authority
//default api provided are /login and /logout
@SpringBootApplication
public class DemoSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityApplication.class, args);
	}

}
