package com.capgemini.greatoutdoor.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.greatoutdoor.dao.ProductDao;
import com.capgemini.greatoutdoor.entity.Product;
import com.capgemini.greatoutdoor.exception.ProductException;

@Service("ProductService")
@Transactional

public class ProductServiceImplementation implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public boolean addProduct(Product productDto) {
		// TODO Auto-generated method stub
		return productDao.addProduct(productDto);
	}

	@Override
	public boolean editProduct(Product productDto, int productId) throws ProductException {
		// TODO Auto-generated method stub
		Product product = productDao.findProductId(productId);
		if (product == null) {
			throw new ProductException("ProductId is Not Available");
		} else {
			productDao.editProduct(productDto, productId);
		}
		return true;

	}

	@Override
	public boolean deleteProductById(int productId) {
		// TODO Auto-generated method stub
		return productDao.deleteProductById(productId);
	}

	@Override
	public Product findProductId(int productId) {
		// TODO Auto-generated method stub
		return productDao.findProductId(productId);
	}

	@Override
	public List<Product> displayAllProducts() {
		// TODO Auto-generated method stub
		return productDao.displayAllProducts();
	}

}
