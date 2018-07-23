package com.oda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oda.domain.Product;
import com.oda.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Product> listProducts(){
        return productService.listAll();
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Product getProduct(@PathVariable Integer id){
        return productService.getById(id);
    }

	@RequestMapping(value = "/product", method = RequestMethod.POST, headers = "Accept=application/json")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveOrUpdate(product);
	}
 
	@RequestMapping(value = "/product", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Product updateProduct(@RequestBody Product product) {
		return productService.saveOrUpdate(product);
	}
    
	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteProduct(@PathVariable("id") Integer id) {
		productService.delete(id);
 	} 
 
}