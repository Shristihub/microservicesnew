package com.orderapp.client.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.orderapp.client.model.BookDto;
import com.orderapp.client.model.JwtToken;

@RestController
@RequestMapping("/order-api/v1")
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;
	private static final String BASEURL = "http://jwt-mongo-api:8082/book-api/v1/user/books";
	
	@Autowired
	private JwtToken jwtToken;
	
	@GetMapping("/orders/show-books")
	public ResponseEntity<List<BookDto>> showBooks(){
//		String url = BASEURL.concat("user/books");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer "+jwtToken.getJwtToken());
		ResponseEntity<List> bookResponse = restTemplate.exchange(BASEURL, HttpMethod.GET,  null,List.class,headers);
		List<BookDto> books = bookResponse.getBody();
		return ResponseEntity.ok(books);
	}
	
//	for order api
//	http://localhost:8085/order-api/v1/orders/books/book-id/2
  // for bookapi		
//	http://jwt-mongo-api:8082/book-api/v1/user/books/bookId/2
	@GetMapping("/orders/books/book-id/{bookId}")
	public ResponseEntity<BookDto> getOne(@PathVariable("bookId") String bookId) {
		
		String url = BASEURL.concat("/bookId/").concat(bookId);
		ResponseEntity<BookDto> bookResponse = restTemplate.getForEntity(url, BookDto.class);
		BookDto book = bookResponse.getBody();
		return ResponseEntity.ok(book);
	}
}
