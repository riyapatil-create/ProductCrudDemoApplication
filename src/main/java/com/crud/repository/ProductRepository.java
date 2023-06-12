package com.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crud.entity.Product;

public interface ProductRepository extends MongoRepository<Product ,Long> {
	
	
}


