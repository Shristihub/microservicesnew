package com.bookapp.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.service.IBookService;

@RestController

public class BookController {

	public IBookService bookService;
	Logger logger = LoggerFactory.getLogger(BookController.class);
	public BookController(IBookService bookService) {
		super();
		this.bookService = bookService;
	}


	@PostMapping("/books/publish")
	public void sendMessageToKafka(){
		logger.info("in controller");
		bookService.showBooks();
	}
}
