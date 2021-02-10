package com.customer.customerservice.repository;

import commonproject.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByMobileNumber(String mobileNumber);
}
