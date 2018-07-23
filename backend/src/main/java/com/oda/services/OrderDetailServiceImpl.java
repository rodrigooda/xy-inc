package com.oda.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oda.domain.OrderDetail;
import com.oda.repositories.OrderDetailRepository;


@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
    private OrderDetailRepository orderDetailRepository;
    
    public OrderDetailServiceImpl() {
    }

    public List<OrderDetail> listAll() {
        List<OrderDetail> OrderDetails = new ArrayList<>();
        orderDetailRepository.findAll().forEach(OrderDetails::add); //fun with Java 8
        return OrderDetails;
    }

    public OrderDetail getById(Integer id) {
        return orderDetailRepository.findById(id).orElse(null);
    }

    public OrderDetail saveOrUpdate(OrderDetail OrderDetail) {
        orderDetailRepository.save(OrderDetail);
        return OrderDetail;
    }

    public void delete(Integer id) {
        orderDetailRepository.deleteById(id);

    }
}
