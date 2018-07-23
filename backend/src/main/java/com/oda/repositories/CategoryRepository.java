package com.oda.repositories;

import org.springframework.data.repository.CrudRepository;

import com.oda.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}