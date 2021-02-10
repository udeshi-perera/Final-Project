package com.customer.customerservice.controller;

import com.customer.customerservice.service.CustomerService;
import commonproject.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String save(@RequestBody Customer customer) {
        customerService.save(customer);
        return "Successfully saved user " + customer.getCustomerName();
    }

    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    public ResponseEntity<Customer> update(@RequestBody Customer customer) {
        Customer customerUpdate = customerService.update(customer);
        return ResponseEntity.ok().body(customerUpdate);
    }

    @RequestMapping(value = "/customer/{number}", method = RequestMethod.GET)
    public List<Customer> viewCustomer(@PathVariable String number) {
        return customerService.findCustomerByMobileNNumber(number);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public List<Customer> viewAllCustomer() {
        return customerService.fetchAllCustomer();
    }
}
