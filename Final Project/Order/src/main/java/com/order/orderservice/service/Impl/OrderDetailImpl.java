package com.order.orderservice.service.Impl;

import com.order.orderservice.repository.OrderDetailRepository;
import com.order.orderservice.repository.OrderRepository;
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

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailImpl implements OrderDetailService {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    OrderRepository orderRepository;

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
        orderDetail.setOrderId(orderRepository.findTopByOrderByIdDesc().getId());
        orderDetail.setStatus(Status.ACTIVE);
        BigDecimal unitPrice = menu.getPricePerItem();
        orderDetail.setPrice(unitPrice.multiply(BigDecimal.valueOf(orderDetail.getQuantity())));
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

    @Override
    public List<OrderDetail> findOrderDetail() {
        int id=orderRepository.findTopByOrderByIdDesc().getId();
        return orderDetailRepository.findByOrderIdAndStatus(id,Status.ACTIVE);
    }

//    public List<OrderDetail> findAllForOrderId(int id){
//         orderRepository.findTopByOrderByIdDesc().getId();
//        return orderDetailRepository.findByOrderId(id);
//    }
}
