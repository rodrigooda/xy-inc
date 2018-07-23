package com.oda.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oda.domain.Category;
import com.oda.dto.CategoryDTO;
import com.oda.services.CategoryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

    @RequestMapping(value = "/category", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Category> listCategorys(){
        return categoryService.listAll();
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Category getCategory(@PathVariable Integer id){
        return categoryService.getById(id);
    }

	@RequestMapping(value = "/category", method = RequestMethod.POST, headers = "Accept=application/json")
	public Category saveCategory(@Valid @RequestBody CategoryDTO category) {
		return categoryService.saveOrUpdate(category.toEntity());
	}
 
	@RequestMapping(value = "/category", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Category updateCategory(@Valid @RequestBody Category category) {
		return categoryService.saveOrUpdate(category);
	}
    
	@RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCategory(@PathVariable("id") Integer id) {
		categoryService.delete(id);
 	} 
 
}