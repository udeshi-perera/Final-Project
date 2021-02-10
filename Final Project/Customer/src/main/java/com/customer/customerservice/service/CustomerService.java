package com.customer.customerservice.service;

import commonproject.model.customer.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    Customer update(Customer customer);

    Customer findCustomerByMobileNNumber(String mobileNumber);

    List<Customer> fetchAllCustomer();
}
