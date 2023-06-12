package com.crud.service;

import java.util.List;

import com.crud.entity.Product;
import com.crud.exception.NoProductFoundException;



public interface IProductService {
	public String saveProduct(Product product);
	List<Product>getAllProduct();
	Product getProductById(Long prodId);
	String deleteProductById(Long prodId);
    Product updateProduct(Long prodId,Product product) throws NoProductFoundException;
}
