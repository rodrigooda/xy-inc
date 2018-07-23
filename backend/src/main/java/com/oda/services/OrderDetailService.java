package com.oda.services;

import java.util.List;

import com.oda.domain.OrderDetail;

/*
*
* @author rodrigooda
*/
public interface OrderDetailService {

    List<OrderDetail> listAll();

    OrderDetail getById(Integer id);

    OrderDetail saveOrUpdate(OrderDetail orderDetail);

    void delete(Integer id);

}