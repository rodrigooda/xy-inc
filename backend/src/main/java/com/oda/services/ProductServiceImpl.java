package com.oda.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oda.domain.Product;
import com.oda.repositories.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
    private ProductRepository productRepository;
    
    public ProductServiceImpl() {
    }

    public List<Product> listAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public Product getById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product saveOrUpdate(Product product) {
        productRepository.save(product);
        return product;
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);

    }
}
