package com.bookapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.service.IBookService;

@RestController
public class BookController {

	@Autowired
	public IBookService bookService;
	
	@PostMapping("/books/consume")
	public String consumeMessageFromKafka(){
		return bookService.getMessage();
	}
}
