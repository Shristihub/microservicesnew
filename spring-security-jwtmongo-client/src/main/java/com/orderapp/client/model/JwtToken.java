package com.orderapp.client.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Component
@ToString
public class JwtToken {

	private  String JwtToken; 
}
