package com.orderapp.client.model;

import org.springframework.stereotype.Component;

@Component
public class BookMapper {

	public Book convertToEntity(BookDto bookDto){
		Book book= new Book();
		// get the property value from DTO
		String author = bookDto.getAuthor();
		// set the value in Book entity
		book.setAuthor(author);
		
		book.setBookId(bookDto.getBookId());
		book.setCategory(bookDto.getCategory());
		book.setPrice(bookDto.getPrice());
		book.setTitle(bookDto.getTitle());
		return book;
	}
	
	public BookDto convertToDto(Book book){
		BookDto bookDto= new BookDto();
		// get the property value from DB as Book
		String author = book.getAuthor();
		// set the value in Book dto Object
		bookDto.setAuthor(author);
		
		bookDto.setBookId(book.getBookId());
		bookDto.setCategory(book.getCategory());
		bookDto.setPrice(book.getPrice());
		bookDto.setTitle(book.getTitle());
		return bookDto;
	}
	
	
	
}
