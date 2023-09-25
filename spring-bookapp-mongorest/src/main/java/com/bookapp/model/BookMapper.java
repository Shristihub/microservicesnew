package com.bookapp.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
	@Autowired
	private PublisherMapper publisherMapper;

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
		List<Publisher> publishers = bookDto.getPublishersDto()
				.stream()
				.map(publisherMapper::convertToEntity)
			.collect(Collectors.toList());

		book.setPublishers(publishers);
		book.setBookTypes(bookDto.getBookTypes());
		book.setGenre(bookDto.getGenre());
		System.out.println(book);
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
		bookDto.setBookTypes(book.getBookTypes());
		List<PublisherDto> publisherDtos = book.getPublishers()
												.stream()
												.map(publisherMapper::convertToDto)
											.collect(Collectors.toList());
		bookDto.setPublishersDto(publisherDtos);
		bookDto.setGenre(book.getGenre());
		return bookDto;
	}
	
	
	
}
