package com.example.demosecurity4.demosecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class FooBarConfig extends WebSecurityConfigurerAdapter {

	// this is for authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("prajul").password("prajul_root").roles("admin_role").and()
				.withUser("onkar").password("onkar_root").roles("student_role");
	}

	// this is for authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// httpBasic always gives json response instaed html page
		http.httpBasic().and().authorizeRequests().antMatchers("/admin/**").hasRole("admin_role")
				.antMatchers("/student/**").hasAnyRole("student_role", "admin_role").antMatchers("/**").permitAll()
				.and().formLogin();
	}

	@Bean
	public PasswordEncoder passWordEncode() {
		return NoOpPasswordEncoder.getInstance();
	}
}
