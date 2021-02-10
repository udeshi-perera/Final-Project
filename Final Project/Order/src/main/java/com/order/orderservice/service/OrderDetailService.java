package com.order.orderservice.service;

import commonproject.model.order.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    OrderDetail save(OrderDetail orderDetail);

    OrderDetail delete(int id);

    List<OrderDetail> findByOrderId(int id);
}
