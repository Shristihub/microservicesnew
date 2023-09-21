package com.orderapp.client.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
	private String userId;
	private String username;
	private String password;
	
	private String email;
	
	private List<String> roles;

}
