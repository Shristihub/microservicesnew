package com.bookapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.model.AppUser;


@Repository
public interface IAppUserRepository extends MongoRepository<AppUser, Integer> {

	AppUser findByUsername(String username);
	
}
