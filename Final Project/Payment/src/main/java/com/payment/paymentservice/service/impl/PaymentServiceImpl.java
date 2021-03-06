package com.payment.paymentservice.service.impl;

import com.payment.paymentservice.dto.OrderDetailDto;
import com.payment.paymentservice.repository.PaymentRepository;
import com.payment.paymentservice.service.PaymentService;
import commonproject.model.order.Order;
import commonproject.model.order.OrderDetail;
import commonproject.model.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class PaymentServiceImpl implements PaymentService {

    @LoadBalanced
    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Payment save(Payment payment) {
        Order getOrderId=restTemplate.getForObject("http://order/services/order", Order.class);
        payment.setOrderId(getOrderId.getId());
        OrderDetailDto orderDetail = restTemplate.getForObject("http://order/services/orderDetail/" + payment.getOrderId(), OrderDetailDto.class);

        BigDecimal totalAmount = new BigDecimal("0.00");
        for (int listSize = 0; listSize < orderDetail.getOrderDetailList().size(); listSize++) {
            BigDecimal sumOfOrderDetail = orderDetail.getOrderDetailList().get(listSize).getPrice();
            totalAmount = sumOfOrderDetail.add(totalAmount);
        }
        payment.setFullPayment(totalAmount);
        System.out.println(totalAmount);
        System.out.println(orderDetail);
        return paymentRepository.save(payment);
    }

    @Override
    public Payment fetchByOrderId(int orderId) {
        return paymentRepository.findByOrderId(orderId);
    }
}
