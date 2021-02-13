package com.order.orderservice.Controller;

import com.order.orderservice.service.OrderService;
import commonproject.model.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin (origins = "*")
@RestController
@RequestMapping("/services")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Order save(Order order) {
        return orderService.save(order);
    }

    @RequestMapping(value = "/order",method = RequestMethod.GET)
    public Order fetch(){
        System.out.println("im backend");
        return orderService.getRecord();
    }
}
