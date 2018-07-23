package com.oda.repositories;

import org.springframework.data.repository.CrudRepository;

import com.oda.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}