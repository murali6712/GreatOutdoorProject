package com.capgemini.greatoutdoor.service;

import java.util.List;

import com.capgemini.greatoutdoor.entity.Product;

public interface ProductService {
	
	public boolean addProduct(Product productDto);
	
	public boolean editProduct(Product productDto, int productId);
	
	public boolean deleteProductById(int productId);
	
	Product findProductId(int productId);	
	
	public List<Product> displayAllProducts();
		
}
