package com.madhan.restapp.service;

import com.madhan.restapp.model.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void addCustomer(Customer customer);
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByEmailAndPassword(String email, String password);
    List<Customer> findAllCustomers();
}
