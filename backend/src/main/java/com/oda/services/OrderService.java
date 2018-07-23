package com.oda.services;

import java.util.List;

import com.oda.domain.Order;

/*
*
* @author rodrigooda
*/
public interface OrderService {

    List<Order> listAll();

    Order getById(Integer id);

    Order saveOrUpdate(Order order);

    void delete(Integer id);

}