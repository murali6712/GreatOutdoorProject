package com.capgemini.greatoutdoor.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.greatoutdoor.entity.Product;
import com.capgemini.greatoutdoor.exception.ProductException;
import com.capgemini.greatoutdoor.service.ProductService;

@RestController
@RequestMapping("/sprintEvaluation")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	/* Json Format
	 * This is a GetMethod(Http) by using "ProductId" is used to fetch the ProductId.
	 * Method 	 : displayProductById
	 * Type 	 : ResponseEntity<Product>
	 * parameters: productId 
	 * Author 	 : MuraliKrishna
	 * Date 	 : 22/09/2020
	 */
	@GetMapping("/view/{productId}")
	public ResponseEntity<Product> displayProductById(@PathVariable("productId") int productId) throws ProductException
	{
		Product obj = productService.findProductId(productId);
		if(obj != null)
		{
			return new ResponseEntity<Product>(obj, HttpStatus.OK);
		}
		else
		{
			throw new ProductException("Unable to find the ProductId" + productId);
		}
		
	}
	
	
	
	/* Json Format
	 * This is a GetMethod(Http) by using "ProductId" is used to fetch the All Products.
	 * Method 	 : displayAllProducts
	 * Type 	 : List<Product>
	 * parameters: null 
	 * Author 	 : MuraliKrishna
	 * Date 	 : 22/09/2020
	 */
	
	
	@GetMapping("/viewAllProducts")
	public List<Product> displayAllProducts() throws ProductException {

		List<Product> productList =productService.displayAllProducts();
		
		if (productList.isEmpty()) 
		{
			throw new ProductException("Product List is Empty");
		}
		else
		{
			return productList;
		}
		
	}
	
	
	
	/* Json Format
	 * This is a PostMethod(Http) by using "ProductDto" is used to add the Products.
	 * Method 	 : addProduct
	 * Type 	 : ResponseEntity<String>
	 * parameters: productDto 
	 * Author 	 : MuraliKrishna
	 * Date 	 : 22/09/2020
	 */
	
	
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody Product productDto) throws ProductException
	{
		String result = null;
		boolean status = productService.addProduct(productDto);
		if(status == true)
		{
			result = "Product Added Successfully";
			return new ResponseEntity<String>(result, HttpStatus.OK);
		}
		else
		{
			throw new ProductException("Unsuccessful While Adding Product");
		}
		
	}
	
	
	/* Json Format
	 * This is a PutMethod(Http) by using "ProductDto" is used to edit the Products.
	 * Method 	 : editProduct
	 * Type 	 : ResponseEntity<String>
	 * parameters: productDto, productId
	 * Author 	 : MuraliKrishna
	 * Date 	 : 22/09/2020
	 */
	
	@PutMapping("/editProduct/{productId}")
	public ResponseEntity<String> editProduct(@RequestBody Product productDto, @PathVariable int productId) throws ProductException
	{
		
		boolean status = productService.editProduct(productDto, productId);
		String result = null;
		
		if(status)
		{
			result = "Product Edited Successfully";
			return new ResponseEntity<String>(result, HttpStatus.OK);
		}
		else
		{
			throw new ProductException("Unsuccessful while Editing Product");
		}
		
	}
	
	
	
	/* Json Format
	 * This is a PutMethod(Http) by using "ProductDto" is used to delete the Product by ProductId.
	 * Method 	 : deleteProductById
	 * Type 	 : ResponseEntity<String>
	 * parameters: productId
	 * Author 	 : MuraliKrishna
	 * Date 	 : 22/09/2020
	 */
	
	@DeleteMapping("/deleteproduct/{productId}")
	public ResponseEntity<String> deleteProductById(@PathVariable("productId") int productId) throws ProductException 
	{
		String result = null;
		boolean status = productService.deleteProductById(productId);
		if(status == true)
		{
			result = "Product Deleted Successfully";
			return new ResponseEntity<String>(result, HttpStatus.OK);
		}
		else
		{
			throw new ProductException("Unsuccessful While Deleting Product");
		}
	}
	
 	

}
