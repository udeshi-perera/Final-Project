package com.customer.customerservice.controller;

import com.customer.customerservice.service.CustomerService;
import commonproject.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import java.sql.SQLIntegrityConstraintViolationException;
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
    public ResponseEntity update(@RequestBody Customer customer) {
        Customer customerUpdate = customerService.update(customer);
        try{
            return ResponseEntity.ok().body(customerUpdate);
        }
        catch (NullPointerException nullPOinterException){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Menu ID does not exist.");
        }
    }

    @RequestMapping(value = "/customer/{number}", method = RequestMethod.GET)
    public ResponseEntity viewCustomer(@PathVariable String number) {
        Customer customerList=customerService.findCustomerByMobileNNumber(number);
        try{
            return ResponseEntity.ok().body(customerList);
        }
        catch (DuplicateKeyException duplicateKeyException){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Mobile Number Cannot be Duplicate");
        }
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public List<Customer> viewAllCustomer() {
        return customerService.fetchAllCustomer();
    }
}
