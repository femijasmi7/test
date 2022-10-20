package com.test.example.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.example.model.EditProduct;
import com.test.example.model.Product;
import com.test.example.model.ProductReq;
import com.test.example.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private SequenceGenerator sequenceGenerator;

	@Autowired
	private ProductRepository productRepository;

	public List<Product> addProducts(@Valid List<ProductReq> req) {

		Iterator<ProductReq> iterator = req.iterator();
		while (iterator.hasNext()) {
			ProductReq productReq = (ProductReq) iterator.next();
			String id = "PD" + sequenceGenerator.getNextID().toString();
			Product product = new Product(id, productReq.getName().toLowerCase(), productReq.getHsnCode(),
					productReq.getCategoryID());
			productRepository.save(product);
		}
		return null;
	}

	public List<Product> getAllProducts() throws Exception {
		List<Product> findAll = productRepository.findAll();
		if (findAll.isEmpty()) {
			throw new Exception("no product found");
		}
		return findAll;
	}

	public Product updateProduct(String productID, EditProduct req) throws Exception {
		Optional<Product> findById = productRepository.findById(productID);
		if (!findById.isPresent()) {
			throw new Exception("product not found");
		}
		Product product = findById.get();

		if (req.getName() != null) {
			product.setName(req.getName());
		}
		if (req.getHsnCode() != null) {
			product.setHsnCode(req.getHsnCode());
		}
		if (req.getCategoryID() != null) {
			product.setCategoryID(req.getCategoryID());
		}

		productRepository.save(product);

		return product;
	}

	public String removeProduct(String productID) throws Exception {
		Optional<Product> findById = productRepository.findById(productID);
		if (!findById.isPresent()) {
			throw new Exception("product not found");
		}
		Product product = findById.get();
		productRepository.delete(product);
		return "product deleted successfully";
	}

	public Product getProductByID(String productID) throws Exception {
		Optional<Product> findById = productRepository.findById(productID);
		if (!findById.isPresent()) {
			throw new Exception("product not found");
		}
		Product product = findById.get();
		return product;
	}

	public List<Product> getProductByName(String name) throws Exception {
		List<Product> findByName = productRepository.findByName(name.toLowerCase());
		if (!findByName.isEmpty()) {
			throw new Exception(" no products found");
		}
		return findByName;
	}

	public List<Product> getProductsByCategory(long categoryID) throws Exception {
		List<Product> findByCategory = productRepository.findByCategory(categoryID);
		if (findByCategory.isEmpty()) {
			throw new Exception(" no products found");
		}
		return findByCategory;
	}

}
