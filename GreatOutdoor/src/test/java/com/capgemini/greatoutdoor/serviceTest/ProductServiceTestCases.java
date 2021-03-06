package com.capgemini.greatoutdoor.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.greatoutdoor.entity.Product;
import com.capgemini.greatoutdoor.exception.ProductException;
import com.capgemini.greatoutdoor.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTestCases {

	@Autowired
	ProductService productService;
	@MockBean
	Product productDto;
	
	@Test
	@DisplayName("Test for adding an product")
	public void addProductTest() throws ProductException
	{
		
		Product product=new Product(15000, "Green", "13*19", "64 MegaPixel", "Lenovo", 10, "Laptop", "Lenovo");
		assertEquals(true,productService.addProduct(product));
		
	}

	@Test
	@DisplayName("Test for deleting a product")
	public void deleteProductTest() throws ProductException {
		Product product = new Product(21, 15000, "Green", "13*19", "64 MegaPixel", "Lenovo", 10, "Laptop", "Lenovo");
		assertEquals(true, productService.deleteProductById(product.getProductId()));

	}

	@Test
	@DisplayName("Test for deleting a product Invalid")
	public void deleteProductTest1() throws ProductException {
		Product product = new Product(25, 15000, "Green", "13*19", "64 MegaPixel", "Lenovo", 10, "Laptop", "Lenovo");
		assertEquals(true, productService.deleteProductById(product.getProductId()));

	}

	@Test
	@DisplayName("Test for viewAllProducts products")
	public void viewAllProducts() {
		List<Product> list = productService.displayAllProducts();
		assertTrue(!list.isEmpty());
		assertFalse(list.isEmpty());

	}
	
	@Test
	@DisplayName("Test for viewAllProducts products Invalid")
	public void viewAllProducts1() {
		List<Product> list = productService.displayAllProducts();
		assertFalse(!list.isEmpty());
		assertTrue(list.isEmpty());

	}

}
