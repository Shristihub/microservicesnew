package com.bookapp.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.AppUser;
import com.bookapp.model.AppUserMapper;
import com.bookapp.service.AppUserServiceImpl;
import com.bookapp.util.JwtTokenUtil;

@RestController
@RequestMapping("/user-api/v1")
public class AppUserController {

	@Autowired
	private AppUserServiceImpl userServiceImpl;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired 
	private PasswordEncoder encoder;
	@Autowired
    JwtTokenUtil tokenUtil;
	
	// 2nd call for the registered user (similar to login - this returns the jwt token)
	@PostMapping("/authenticate")
	public ResponseEntity<String> generateToken(@RequestBody AppUser appUser){
		System.out.println(appUser);
		authenticate(appUser.getUsername(), appUser.getPassword());
		UserDetails userDetails =  userServiceImpl.loadUserByUsername(appUser.getUsername());
		String token = tokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(token);
	}
    // 1st call for any new user 
	@PostMapping("/register")
	public ResponseEntity<Void> addUser(@RequestBody AppUser appUser) {
		UserDetails userDetails = convertToUserDetails(appUser);
		userServiceImpl.createUser(userDetails);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	private void authenticate(String username, String password) {
		try {
			System.out.println(username);
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			System.out.println(authentication.getPrincipal());
		} catch (BadCredentialsException e) {
			System.out.println("Invalid credentials");
		} catch (DisabledException e) {
			System.out.println("disabled");
		}
	}
	

	private UserDetails convertToUserDetails(AppUser appUser) {
		String username = appUser.getUsername();
		String password = encoder.encode(appUser.getPassword());
		List<GrantedAuthority>  authorities = appUser.getRoles()
							.stream()
							.map(role->new SimpleGrantedAuthority(role))
							.collect(Collectors.toList());
		// create a User object
		UserDetails userDetails = new User(username, password, authorities);
		
		return userDetails;				
	}
}
