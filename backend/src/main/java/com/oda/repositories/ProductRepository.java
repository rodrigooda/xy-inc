package com.oda.repositories;

import org.springframework.data.repository.CrudRepository;

import com.oda.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}