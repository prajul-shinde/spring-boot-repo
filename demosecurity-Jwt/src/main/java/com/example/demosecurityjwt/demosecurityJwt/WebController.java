package com.example.demosecurityjwt.demosecurityJwt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class WebController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private Utils jwtTokenUtil;

	@Autowired
	private MyUserDetailService userDetailsService;

	@GetMapping(value = "/user")
	public String firstPage(HttpServletRequest request) {
		System.out.println(request.getHeader("Authorization"));
		System.out.println(request.getCookies());
		System.out.println(request.getAuthType());
		return "Hello Users";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return new AuthenticationResponse(jwt);
	}

}