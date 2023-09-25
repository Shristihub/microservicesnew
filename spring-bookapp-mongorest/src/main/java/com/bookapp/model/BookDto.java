package com.bookapp.model;

import java.util.Arrays;
import java.util.List;

public class BookDto {
	private String title;
	private String author;
	private String bookId;
	private double price;
	private String category;
	private String[] bookTypes;
	private List<PublisherDto> publishersDto;
	private Genre genre;
	public BookDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookDto(String title, String author,String bookId, double price, String category) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.category = category;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String[] getBookTypes() {
		return bookTypes;
	}
	public void setBookTypes(String[] bookTypes) {
		this.bookTypes = bookTypes;
	}
	public List<PublisherDto> getPublishersDto() {
		return publishersDto;
	}
	public void setPublishersDto(List<PublisherDto> publishersDto) {
		this.publishersDto = publishersDto;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "BookDto [title=" + title + ", author=" + author + ", bookId=" + bookId + ", price=" + price
				+ ", category=" + category + ", bookTypes=" + Arrays.toString(bookTypes) + ", publishers=" + publishersDto
				+ ", genre=" + genre + "]";
	}
	
	
}
