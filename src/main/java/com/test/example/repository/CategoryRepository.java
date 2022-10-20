package com.test.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.test.example.model.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, Long> {

}
