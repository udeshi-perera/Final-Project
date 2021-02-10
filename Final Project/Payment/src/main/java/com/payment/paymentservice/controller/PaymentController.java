package com.payment.paymentservice.controller;

import com.payment.paymentservice.service.PaymentService;
import commonproject.model.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public Payment save(@RequestBody Payment payment) {
        return paymentService.save(payment);
    }

    @RequestMapping(value = "/payment/{id}", method = RequestMethod.GET)
    public Payment fetchByOrderId(@PathVariable int id) {
        return paymentService.fetchByOrderId(id);
    }
}
