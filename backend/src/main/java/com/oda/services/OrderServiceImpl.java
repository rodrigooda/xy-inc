package com.oda.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oda.domain.Client;
import com.oda.domain.Order;
import com.oda.repositories.ClientRepository;
import com.oda.repositories.OrderRepository;


@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
    private OrderRepository orderRepository;
	@Autowired
    private ClientService clientService;
	
    public OrderServiceImpl() {
    }

    public List<Order> listAll() {
        List<Order> Orders = new ArrayList<>();
        orderRepository.findAll().forEach(Orders::add); //fun with Java 8
        return Orders;
    }

    public Order getById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order saveOrUpdate(Order order) {
    	Client client = clientService.getById(order.getClientId().getId());
        order.setClientId(client);
    	return orderRepository.save(order);
    }

    public void delete(Integer id) {
        orderRepository.deleteById(id);

    }
}
