package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.BookDto;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookappMongoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappMongoApplication.class, args);
	}

		@Autowired
		private IBookService bookService;
		@Override
		public void run(String... args) throws Exception {
			BookDto bookDto = new BookDto("Java", "A001","Kathy",900, "tech");
			bookService.addBook(bookDto);
			bookDto = new BookDto("Spring","A002", "John",1900, "tech");
			bookService.addBook(bookDto);
			
//			bookService.getAll().forEach(System.out::println);
//			System.out.println();
//			BookDto newBookDto = bookService.getById("1");
//			System.out.println(newBookDto);
//			
//			// updating
//			newBookDto.setPrice(1000);
//			newBookDto.setAuthor("Kathy Sierra");
//			bookService.updateBook(newBookDto);
//			
////			bookService.getByAuthor("John").forEach(System.out::println);
		}
			
}
