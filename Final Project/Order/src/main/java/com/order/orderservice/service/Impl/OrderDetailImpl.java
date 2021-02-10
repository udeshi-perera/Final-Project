package com.order.orderservice.service.Impl;

import com.order.orderservice.repository.OrderDetailRepository;
import com.order.orderservice.service.OrderDetailService;
import commonproject.enumorator.Status;
import commonproject.model.menu.Menu;
import commonproject.model.order.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailImpl implements OrderDetailService {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @LoadBalanced
    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    @Autowired
    RestTemplate restTemplate;

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        Menu menu = restTemplate.getForObject("http://menu/menu/" + orderDetail.getMenu(), Menu.class);
        orderDetail.setStatus(Status.ACTIVE);
        float unitPrice = menu.getPricePerItem();
        orderDetail.setPrice(unitPrice * orderDetail.getQuantity());
        orderDetail.setStatus(Status.ACTIVE);
        System.out.println(orderDetail);
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail delete(int id) {
        Optional<OrderDetail> optionalOrderDetail = orderDetailRepository.findById(id);
        OrderDetail orderDetail = optionalOrderDetail.get();
        orderDetail.setStatus(Status.DEACTIVE);
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public List<OrderDetail> findByOrderId(int id) {
        return orderDetailRepository.findByOrderId(id);
    }
}
