package com.bookapp.service;

import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.model.BookDto;

public interface IBookService {
	void addBook(BookDto bookDto);
	void updateBook(BookDto bookDto);
	BookDto getById(String bookId) throws BookNotFoundException;
	void deleteBook(String bookId);
	List<BookDto> getAll();
	List<BookDto> getByAuthor(String author) throws BookNotFoundException;
	List<BookDto> getByPriceLessThan(double price) throws BookNotFoundException;
	List<BookDto> getByCategory(String category) throws BookNotFoundException;
	
	//custom query
	List<BookDto> getByAuthPrice(String author, double cost);
	List<BookDto> getByAuthAndPrice(String author, double cost);
}
