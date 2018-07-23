package com.oda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oda.domain.Order;
import com.oda.services.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Order> listOrders(){
        return orderService.listAll();
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Order getOrder(@PathVariable Integer id){
        return orderService.getById(id);
    }

	@RequestMapping(value = "/order", method = RequestMethod.POST, headers = "Accept=application/json")
	public Order saveOrder(@RequestBody Order order) {
		return orderService.saveOrUpdate(order);
	}
 
	@RequestMapping(value = "/order", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Order updateOrder(@RequestBody Order order) {
		return orderService.saveOrUpdate(order);
	}
    
	@RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteOrder(@PathVariable("id") Integer id) {
		orderService.delete(id);
 	} 
 
}