package com.order.orderservice.repository;

import commonproject.enumorator.Status;
import commonproject.model.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    List<OrderDetail> findByOrderId(int orderId);

    List<OrderDetail> findByOrderIdAndStatus(int orderId, Status status);
}
