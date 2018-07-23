package com.oda.services;

import java.util.List;

import com.oda.domain.Product;

/*
*
* @author rodrigooda
*/
public interface ProductService {

    List<Product> listAll();

    Product getById(Integer id);

    Product saveOrUpdate(Product product);

    void delete(Integer id);

}