package com.test.example.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.example.model.Category;
import com.test.example.model.CategoryReq;
import com.test.example.model.Product;
import com.test.example.repository.CategoryRepository;
import com.test.example.repository.ProductRepository;

@Service
public class CategoryService {

	@Autowired
	private SequenceGenerator sequenceGenerator;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	public List<Category> addCategory(@Valid List<CategoryReq> req) {
		Iterator<CategoryReq> iterator = req.iterator();
		while (iterator.hasNext()) {
			CategoryReq categoryReq = (CategoryReq) iterator.next();

			Category category = new Category(sequenceGenerator.getNextID(), categoryReq.getName());
			categoryRepository.save(category);
		}
		return null;
	}

	public List<Category> getAllCategories() throws Exception {
		List<Category> findAll = categoryRepository.findAll();
		if (findAll.isEmpty()) {
			throw new Exception("No category found");
		}
		return findAll;
	}

	public Category getCategoryByID(long categoryID) throws Exception {
		Optional<Category> findById = categoryRepository.findById(categoryID);
		if (!findById.isPresent()) {
			throw new Exception("Category not found");
		}
		Category category = findById.get();
		return category;
	}

	public Category updateCategory(long categoryID, @Valid String name) throws Exception {
		Optional<Category> findById = categoryRepository.findById(categoryID);
		if (!findById.isPresent()) {
			throw new Exception("Category not found");
		}
		Category category = findById.get();
		category.setName(name);
		categoryRepository.save(category);
		return category;
	}

	public String removeCategory(long categoryID) throws Exception {
		List<Product> findByCategory = productRepository.findByCategory(categoryID);
		if (!findByCategory.isEmpty()) {
			throw new Exception("Category cannot be deleted because products are found in this category");
		}

		Optional<Category> findById = categoryRepository.findById(categoryID);
		if (!findById.isPresent()) {
			throw new Exception("Category not found");
		}

		categoryRepository.deleteById(categoryID);

		return "Category deleted successfully";
	}

}
