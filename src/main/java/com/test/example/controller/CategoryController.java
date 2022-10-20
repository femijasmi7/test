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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.example.model.Category;
import com.test.example.model.CategoryReq;
import com.test.example.service.CategoryService;

@RestController
@RequestMapping("/v1")
public class CategoryController {

	org.slf4j.Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/categories")
	public ResponseEntity<?> addCategory(@Valid @RequestBody List<CategoryReq> req) {
		logger.info("add new category");
		List<Category> res = categoryService.addCategory(req);
		return ResponseEntity.status(HttpStatus.CREATED).body(res);
	}

	@GetMapping("/categories")
	public ResponseEntity<?> getAllCategories() throws Exception {
		logger.info("get all categories");
		List<Category> res = categoryService.getAllCategories();
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@GetMapping("/categories/{categoryID}")
	public ResponseEntity<?> getCategoryByID(@PathVariable(name = "categoryID") long categoryID) throws Exception {
		logger.info("get category by id");
		Category res = categoryService.getCategoryByID(categoryID);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@PutMapping("/categories/{categoryID}")
	public ResponseEntity<?> updateCategory(@PathVariable(name = "categoryID") long categoryID,
			@RequestParam(name = "name", required = true) String name) throws Exception {
		logger.info("edit a category");
		Category res = categoryService.updateCategory(categoryID, name);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@DeleteMapping("/categories/{categoryID}")
	public ResponseEntity<?> removeCategory(@PathVariable(name = "categoryID") long categoryID) throws Exception {
		logger.info("delete a category");
		String res = categoryService.removeCategory(categoryID);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

}
