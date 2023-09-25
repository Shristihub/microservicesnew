package com.bookapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.BookDto;
import com.bookapp.service.IBookService;

@RestController
@RequestMapping("/book-api/v1")
public class BookController {

	private IBookService bookService;
	
	public BookController(IBookService bookService) {
		super();
		this.bookService = bookService;
	}
	@PostMapping("/books")
	void addBook(@RequestBody BookDto bookDto) {
		bookService.addBook(bookDto);
	}
	@PutMapping("/books")
	void updateBook(@RequestBody BookDto bookDto){
		bookService.updateBook(bookDto);
	}
	@GetMapping("/books/bookId/{bookId}")
	BookDto getById(@PathVariable("bookId") String bookId) throws BookNotFoundException{
		return bookService.getById(bookId);
	}
	@DeleteMapping("/books/bookId/{bookId}")
	void deleteBook(@PathVariable("bookId") String bookId){
		bookService.deleteBook(bookId);
	}
	
	@GetMapping("/books")
	List<BookDto> getAll(){
		return bookService.getAll();
	}
	
	@GetMapping("/books/author/{author}")
	List<BookDto> getByAuthor(@PathVariable("author") String author) throws BookNotFoundException{
		return bookService.getByAuthor(author);
	}
	@GetMapping("/books/price/{price}")
	List<BookDto> getByPriceLessThan(@PathVariable("price")double price) throws BookNotFoundException{
		return bookService.getByPriceLessThan(price);
	}
//	http://localhost:8081/book-api/v1/books/category?category=tech
	@GetMapping("/books/category")
	List<BookDto> getByCategory(@RequestParam("category") String category) throws BookNotFoundException{
		return bookService.getByCategory(category);
	}
	@GetMapping("/books/author/{author}/cost/{cost}")
	List<BookDto> getByAuthPrice(@PathVariable("author")String author,@PathVariable("cost") double cost){
		return bookService.getByAuthAndPrice(author, cost);
	}
	@GetMapping("/books/nauthor/{author}/ncost/{cost}")
	List<BookDto> getByAuthAndPrice(@PathVariable("author")String author,@PathVariable("cost") double cost){
		return bookService.getByAuthAndPrice(author, cost);
	}
}
