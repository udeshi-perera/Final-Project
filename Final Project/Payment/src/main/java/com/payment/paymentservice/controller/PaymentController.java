package com.payment.paymentservice.controller;

import com.payment.paymentservice.service.PaymentService;
import commonproject.model.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
@CrossOrigin(origins = "*")
@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public Payment save(Payment payment) {
       return paymentService.save(payment);
//        try{
//            return ResponseEntity.ok(newPayment);
//        }catch (NullPointerException nullPOinterException){
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("OrderDetail ID is not exists");
//        }
    }

    @RequestMapping(value = "/payment/{id}", method = RequestMethod.GET)
    public ResponseEntity fetchByOrderId(@PathVariable int id) {
        Payment payment= paymentService.fetchByOrderId(id);
        try{
            return ResponseEntity.ok(payment);
        }
        catch (NullPointerException nullPOinterException){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Order Id does not exist");
        }
    }
}
