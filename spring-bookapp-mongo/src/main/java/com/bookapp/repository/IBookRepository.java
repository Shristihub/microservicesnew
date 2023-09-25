package com.bookapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;

@Repository
public interface IBookRepository extends MongoRepository<Book, String> {
	// derived queries
	List<Book> findByAuthor(String author);

	List<Book> findByCategory(String category);

	List<Book> findByPriceLessThan(double price);

//	// custom query
	@Query("{author:?0,price:{$lte:?1}}")
	List<Book> findByAuthPrice(String author, double cost);

	@Query("{$or:[{author:?1,price:{$lte:?2}}]}")
	List<Book> findByAuthAndPrice(String author, double cost);

}


