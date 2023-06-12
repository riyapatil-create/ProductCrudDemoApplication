package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Product;
import com.crud.exception.NoProductFoundException;
import com.crud.service.IProductService;

@RestController
@RequestMapping("/product/")
public class ProductController {
	
	@Autowired
	IProductService	productService;
	
	@PostMapping("/save")
	public ResponseEntity<String>createProduct(@RequestBody Product product){
		return new ResponseEntity<String>(productService.saveProduct(product),HttpStatus.OK);
	}
	
	
	@GetMapping("/getall")
	public ResponseEntity<List<Product>> readAllProduct(){
	return new ResponseEntity<List<Product>>(productService.getAllProduct(),HttpStatus.OK);
		
	}
	
	@GetMapping("/get/{prodId}")
	public ResponseEntity<Product> readProductById(@PathVariable Long prodId){
		return new ResponseEntity<Product>(productService.getProductById(prodId),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{prodId}")
	public ResponseEntity<String>deleteProductById(@PathVariable Long prodId){
		return new ResponseEntity<String>(productService.deleteProductById(prodId),HttpStatus.OK);
	}
	
	@PutMapping("/update/{prodId}")
	public ResponseEntity<Product>updateProduct(@PathVariable Long prodId,@RequestBody Product product) throws NoProductFoundException{
		return new ResponseEntity<Product>(productService.updateProduct(prodId,product),HttpStatus.OK);
	}
	
	

}
