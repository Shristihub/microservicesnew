package com.bookapp.controllers;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.bookapp.model.Book;
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
	ResponseEntity<Void> addBook(@RequestBody BookDto bookDto) {
		bookService.addBook(bookDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@PutMapping("/books")
	ResponseEntity<Void> updateBook(@RequestBody BookDto bookDto){
		bookService.updateBook(bookDto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "updating one book  ");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
	}
	@GetMapping("/books/bookId/{bookId}")
	ResponseEntity<BookDto> getById(@PathVariable("bookId") String bookId) throws BookNotFoundException{
		BookDto book = bookService.getById(bookId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "getting one book by id "+bookId);
		return ResponseEntity.ok().headers(headers).body(book);
	}
	@DeleteMapping("/books/bookId/{bookId}")
	ResponseEntity<Void> deleteBook(@PathVariable("bookId") String bookId){
		bookService.deleteBook(bookId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "deleting one book by id "+bookId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
	}
	
	@GetMapping("/books")
	ResponseEntity<List<BookDto>> getAll(){
		List<BookDto> bookDtos =  bookService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "getting all books");
		ResponseEntity<List<BookDto>> responseEntity = 
				new ResponseEntity<List<BookDto>>(bookDtos, headers, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/books/author/{author}")
	ResponseEntity<List<BookDto>> getByAuthor(@PathVariable("author") String author) throws BookNotFoundException{
		List<BookDto> bookDtos =  bookService.getByAuthor(author);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "getting all books by author");
		return ResponseEntity.ok().headers(headers).body(bookDtos);
	}
	@GetMapping("/books/price/{price}")
	ResponseEntity<List<BookDto>> getByPriceLessThan(@PathVariable("price")double price) throws BookNotFoundException{
		List<BookDto> bookDtos = bookService.getByPriceLessThan(price);
		return ResponseEntity.ok(bookDtos);
		
	}
//	http://localhost:8081/book-api/v1/books/category?category=tech
	@GetMapping("/books/category")
	ResponseEntity<List<BookDto>> getByCategory(@RequestParam("category") String category) throws BookNotFoundException{
		List<BookDto> bookDtos =  bookService.getByCategory(category);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "getting all books by category "+category);
		return ResponseEntity.ok().headers(headers).body(bookDtos);
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
