package com.oda.repositories;

import org.springframework.data.repository.CrudRepository;

import com.oda.domain.OrderDetail;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, Integer> {
}