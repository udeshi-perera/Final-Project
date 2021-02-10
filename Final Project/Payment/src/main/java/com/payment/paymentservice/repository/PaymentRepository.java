package com.payment.paymentservice.repository;

import commonproject.model.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    Payment findByOrderId(int orderId);
}
