package com.test.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
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

import com.test.example.model.EditProduct;
import com.test.example.model.Product;
import com.test.example.model.ProductReq;
import com.test.example.service.ProductService;

@RestController
@RequestMapping("/v1")
public class ProductController {

	org.slf4j.Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	public ResponseEntity<?> addProducts(@Valid @RequestBody List<ProductReq> req) {
		logger.info("add new products");
		List<Product> res = productService.addProducts(req);
		return ResponseEntity.status(HttpStatus.CREATED).body(res);
	}

	@GetMapping("/products")
	public ResponseEntity<?> getAllProducts() throws Exception {
		logger.info("get all products");
		List<Product> res = productService.getAllProducts();
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@GetMapping("/products/{name}")
	public ResponseEntity<?> getProductByID(@PathVariable(name = "name") String name) throws Exception {
		logger.info("get products by name");
		List<Product> res = productService.getProductByName(name);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@GetMapping("/products/{categoryID}")
	public ResponseEntity<?> getProductsByCategory(@PathVariable(name = "categoryID") long categoryID)
			throws Exception {
		logger.info("get products by Category");
		List<Product> res = productService.getProductsByCategory(categoryID);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@PutMapping("/products/{productID}")
	public ResponseEntity<?> updateProduct(@PathVariable(name = "productID") String productID,
			@RequestBody EditProduct req) throws Exception {
		logger.info("edit a product");
		Product res = productService.updateProduct(productID, req);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@DeleteMapping("/products/{productID}")
	public ResponseEntity<?> removeProduct(@PathVariable(name = "productID") String productID) throws Exception {
		logger.info("delete a product");
		String res = productService.removeProduct(productID);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

}
