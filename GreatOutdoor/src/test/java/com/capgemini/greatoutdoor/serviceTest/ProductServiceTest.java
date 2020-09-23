package com.capgemini.greatoutdoor.serviceTest;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.greatoutdoor.entity.Product;
import com.capgemini.greatoutdoor.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductServiceTest {
	
	
	@Autowired
	ProductService productService;
	
	
	@Rollback(false)
	@Test
	@DisplayName("Test for adding an product")
	public void addProduct()
	{
		Product product=new Product(20,1500,"Red","15*18","8GB RAM","Lenovo",10,"Laptop","Lenovo");
		assertEquals(true,productService.addProduct(product));
		
		product=new Product(20,1500,"Red","15*18","8GB RAM","Lenovo",10,"Laptop","LenovoLaptop");
		assertEquals(false,productService.addProduct(product));
	}

}
