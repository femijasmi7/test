package com.test.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.example.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	@Query(value = "{categoryID:?0}")
	public List<Product> findByCategory(long categoryID);

	@Query(value = "{name:?0}")
	public List<Product> findByName(String name);
}
