package com.payment.paymentservice.service;

import commonproject.model.payment.Payment;

public interface PaymentService {

    Payment save(Payment payment);

    Payment fetchByOrderId(int orderId);
}
