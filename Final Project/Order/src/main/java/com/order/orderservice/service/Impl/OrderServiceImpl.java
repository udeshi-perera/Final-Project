package com.order.orderservice.service.Impl;

import com.order.orderservice.repository.OrderRepository;
import com.order.orderservice.service.OrderService;
import commonproject.model.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order save(Order order) {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date date = new Date();
        order.setOrderDateTime((dateFormat.format(date)));
        return orderRepository.save(order);
    }

    @Override
    public Order getRecord() {
        return orderRepository.findTopByOrderByIdDesc();
    }
}
