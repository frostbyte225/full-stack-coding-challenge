package com.ibm.fscc.loginservice.controller;

import com.ibm.fscc.loginservice.data.AuthenticationResponse;
import com.ibm.fscc.loginservice.data.LoginEntity;
import com.ibm.fscc.loginservice.data.LoginEntityDetailServiceImpl;
import com.ibm.fscc.loginservice.repository.LoginRepository;
import com.ibm.fscc.loginservice.security.JWTAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="")
@CrossOrigin(originPatterns = "*")
public class LoginController {

	@Autowired
	private Environment env;

	@Autowired
	private LoginRepository repo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping(path="/status/check")
	public String status() {
		return "Working on port " + env.getProperty("server.port");
	}

	@PostMapping(path = "/sign-up")
	public void signUp(@RequestBody LoginEntity user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		repo.save(user);
	}

	@GetMapping(path = "/logins")
	public List<LoginEntity> getAllLogins() {
		return repo.findAll();
	}

	// login auto-generated through auth0 - jwt filtering

}
