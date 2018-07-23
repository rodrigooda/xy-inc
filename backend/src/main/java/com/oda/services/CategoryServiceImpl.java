package com.oda.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oda.domain.Category;
import com.oda.repositories.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl() {
    }

    public List<Category> listAll() {
        List<Category> Categorys = new ArrayList<>();
        categoryRepository.findAll().forEach(Categorys::add); //fun with Java 8
        return Categorys;
    }

    public Category getById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category saveOrUpdate(Category Category) {
        categoryRepository.save(Category);
        return Category;
    }

    public void delete(Integer id) {
        categoryRepository.deleteById(id);

    }
}
