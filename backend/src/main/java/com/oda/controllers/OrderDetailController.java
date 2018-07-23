package com.oda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oda.domain.OrderDetail;
import com.oda.services.OrderDetailService;

@RestController
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDetailService;

    @RequestMapping(value = "/order-detail", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<OrderDetail> listOrderDetails(){
        return orderDetailService.listAll();
    }

    @RequestMapping(value = "/order-detail/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public OrderDetail getOrderDetail(@PathVariable Integer id){
        return orderDetailService.getById(id);
    }

	@RequestMapping(value = "/order-detail", method = RequestMethod.POST, headers = "Accept=application/json")
	public OrderDetail saveOrderDetail(@RequestBody OrderDetail orderDetail) {
		return orderDetailService.saveOrUpdate(orderDetail);
	}
 
	@RequestMapping(value = "/order-detail", method = RequestMethod.PUT, headers = "Accept=application/json")
	public OrderDetail updateOrderDetail(@RequestBody OrderDetail orderDetail) {
		return orderDetailService.saveOrUpdate(orderDetail);
	}
    
	@RequestMapping(value = "/order-detail/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteOrderDetail(@PathVariable("id") Integer id) {
		orderDetailService.delete(id);
 	} 
 
}