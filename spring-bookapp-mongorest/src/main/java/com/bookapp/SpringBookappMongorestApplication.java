package com.bookapp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.BookDto;
import com.bookapp.model.Genre;
import com.bookapp.model.PublisherDto;
import com.bookapp.service.IBookService;
import com.bookapp.service.IPublisherService;

@SpringBootApplication
public class SpringBookappMongorestApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappMongorestApplication.class, args);
	}

	@Autowired
	private IBookService bookService;
	
	@Autowired
	private IPublisherService publisherService;
	
	@Override
	public void run(String... args) throws Exception {
		BookDto bookDto = new BookDto();
		bookDto.setAuthor("Kathy");
		bookDto.setBookId("B100");
		bookDto.setBookTypes(new String[]{"ebookDto","paperback"});
		bookDto.setCategory("tech");
		bookDto.setTitle("Java in action");
		bookDto.setGenre(new Genre("technical","20-50years"));
		bookDto.setPrice(1000);
		PublisherDto pub1 = new PublisherDto("A30","Hall Publishers");
		PublisherDto pub2 = new PublisherDto("A40","New Publishers");
		
		bookDto.setPublishersDto(Arrays.asList(pub1,pub2));
//		bookService.addBook(bookDto);
		
		
		
		
	}

}
