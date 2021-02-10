package com.payment.paymentservice.service.impl;

import com.payment.paymentservice.dto.OrderDetailDto;
import com.payment.paymentservice.repository.PaymentRepository;
import com.payment.paymentservice.service.PaymentService;
import commonproject.model.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
//@JsonIgnoreProperties(ignoreUnknown = true)
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
        OrderDetailDto orderDetail = restTemplate.getForObject("http://order/orderDetail/" + payment.getOrderId(), OrderDetailDto.class);

        float totalAmount = 0;
        for (int i = 0; i < orderDetail.getOrderDetailList().size(); i++) {
            float a = orderDetail.getOrderDetailList().get(i).getPrice();
            totalAmount = a + totalAmount;
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
