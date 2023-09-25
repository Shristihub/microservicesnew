package com.bookapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.model.BookDto;
import com.bookapp.model.BookMapper;
import com.bookapp.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService{
	
	@Autowired
	private IBookRepository bookRepository;
	
	@Autowired
	private BookMapper bookMapper;

	@Override
	public void addBook(BookDto bookDto) {
		bookRepository.insert(bookMapper.convertToEntity(bookDto));
	}

	@Override
	public void updateBook(BookDto bookDto) {
		bookRepository.save(bookMapper.convertToEntity(bookDto));
	}

	@Override
	public BookDto getById(String bookId) throws BookNotFoundException {
		Book book =  bookRepository.findById(bookId).orElseThrow(()-> new BookNotFoundException());
		return bookMapper.convertToDto(book);
	}

	@Override
	public List<BookDto> getByAuthPrice(String author, double cost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDto> getByAuthAndPrice(String author, double cost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBook(String bookId) {
		bookRepository.deleteById(bookId);
	}

	@Override
	public List<BookDto> getAll() {
		List<Book> books = bookRepository.findAll();
		List<BookDto> bookDtoList = books.stream()
				.map(book->bookMapper.convertToDto(book))
				.collect(Collectors.toList());
		return bookDtoList;
	}

	@Override
	public List<BookDto> getByAuthor(String author) throws BookNotFoundException {
		List<Book> books = bookRepository.findByAuthor(author);
		List<BookDto> bookDtoList = books.stream()
				.map(book->bookMapper.convertToDto(book))
				.collect(Collectors.toList());
		if(bookDtoList.isEmpty()) {
			throw new BookNotFoundException("author not found");
		}
		return bookDtoList;
	}

	@Override
	public List<BookDto> getByPriceLessThan(double price) throws BookNotFoundException {
		return null;
	}

	@Override
	public List<BookDto> getByCategory(String category) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
