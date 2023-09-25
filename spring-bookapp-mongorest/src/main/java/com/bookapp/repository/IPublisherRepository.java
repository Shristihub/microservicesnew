package com.bookapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Publisher;

@Repository
public interface IPublisherRepository extends MongoRepository<Publisher, String> {
	
}


