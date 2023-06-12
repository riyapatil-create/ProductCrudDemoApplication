package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Product;
import com.crud.exception.NoProductFoundException;
import com.crud.repository.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	ProductRepository prodRepo;
	
	@Override
	public String saveProduct(Product product) {
		// TODO Auto-generated method stub
		Product temp =prodRepo.save(product);
		return "Product id: "+temp.getProdId()+" is saved successfully!";
		
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return prodRepo.findAll();
	}

	@Override
	public Product getProductById(Long prodId) {
		// TODO Auto-generated method stub
		return prodRepo.findById(prodId).get();
	}

	@Override
	public String deleteProductById(Long prodId) {
		// TODO Auto-generated method stub
		
		boolean delete=false;
		if(prodRepo.existsById(prodId)) {
			prodRepo.deleteById(prodId);
			delete=true;
		}
		return "Product with Id: "+prodId+" deleted status "+ delete;
	}

	@Override
	public Product updateProduct(Long prodId, Product product) throws NoProductFoundException {
		// TODO Auto-generated method stub
	Optional<Product>existing=prodRepo.findById(prodId);
	Product existProduct=null;
	if(existing.isPresent()) {
		 existProduct=existing.get();
		existProduct.setProdName(product.getProdName());
		existProduct.setPrice(product.getPrice());
		existProduct.setDesc(product.getDesc());
		
		prodRepo.save(existProduct);
	}
	
	if(existProduct==null) {
		throw new NoProductFoundException("Product Not Found");
	}
		return existProduct;
	}

}
