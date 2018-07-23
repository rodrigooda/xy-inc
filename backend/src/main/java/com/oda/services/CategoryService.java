package com.oda.services;

import java.util.List;

import com.oda.domain.Category;

/*
*
* @author rodrigooda
*/
public interface CategoryService {

    List<Category> listAll();

    Category getById(Integer id);

    Category saveOrUpdate(Category category);

    void delete(Integer id);

}