package com.capgemini.greatoutdoor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.capgemini.greatoutdoor.entity.Product;


@Repository
@Transactional

public class ProductDaoImplementation implements ProductDao{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public boolean addProduct(Product productDto) {
		// TODO Auto-generated method stub
		entityManager.persist(productDto);
		return true;
	}

	@Override
	public boolean editProduct(Product productDto, int productId) {
		// TODO Auto-generated method stub
		
		Product updateProduct = entityManager.find(Product.class, productId);
		updateProduct.setColour(productDto.getColour());
		updateProduct.setDimension(productDto.getDimension());
		updateProduct.setManufacturer(productDto.getManufacturer());
		updateProduct.setPrice(productDto.getPrice());
		updateProduct.setProductCategory(productDto.getProductCategory());
		updateProduct.setProductName(productDto.getProductName());
		updateProduct.setQuantity(productDto.getQuantity());
		updateProduct.setSpecification(productDto.getSpecification());
		entityManager.merge(productDto);
		return true;
	}
	
	@Override
	public boolean deleteProductById(int productId) {
		// TODO Auto-generated method stub
		
		Product order = entityManager.find(Product.class,productId);
		if(order != null  )
		{
			entityManager.remove(order);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public Product findProductId(int productId) {
		// TODO Auto-generated method stub
		
		Product order = entityManager.find(Product.class, productId);
		if(order!=null )
		{
			 return order; 
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public List<Product> displayAllProducts() {
		// TODO Auto-generated method stub
		
		String getAllProducts = "SELECT products FROM Product products";
		TypedQuery<Product> query = entityManager.createQuery(getAllProducts, Product.class);
		return query.getResultList();
	}

	

}
