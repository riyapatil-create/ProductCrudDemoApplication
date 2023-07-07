package com.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.crud.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product ,Long> {

	Product findByProdName(String prodName);
	
	
}


