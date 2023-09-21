package com.orderapp.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.orderapp.client.model.AppUser;
import com.orderapp.client.model.JwtToken;

@RestController
@RequestMapping("/order-user-api/v1")
public class UserController {

	@Autowired
	private RestTemplate restTemplate;
	private static final String BASEURL = "http://jwt-mongo-api:8081/user-api/v1";
	
	@Autowired
	private JwtToken jwtToken;
	
	@PostMapping("/users/register")
	public ResponseEntity<String> registerUser(@RequestBody AppUser appUser){
		String url =BASEURL.concat("/register");
		ResponseEntity<Void> response = restTemplate.postForEntity(url, appUser,Void.class);
		HttpStatusCode  statuscode = response.getStatusCode();
		System.out.println(statuscode);
		return ResponseEntity.status(statuscode).body(statuscode.toString());
	}
	
	@PostMapping("/users/login")
	public ResponseEntity<String> loginUser(@RequestBody AppUser appUser){
		String url =BASEURL.concat("/authenticate");
		ResponseEntity<String> response = restTemplate.postForEntity(url, appUser,String.class);
		HttpStatusCode  statuscode = response.getStatusCode();
		System.out.println(statuscode);
		System.out.println(response.getBody());
		jwtToken.setJwtToken(response.getBody());
		return ResponseEntity.status(statuscode).body(response.getBody());
	}
	
}
