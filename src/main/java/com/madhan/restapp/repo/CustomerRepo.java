package com.madhan.restapp.repo;

import java.util.List;
import java.util.Optional;

import com.madhan.restapp.model.Customer;

public interface CustomerRepo {

	List<Customer> findAll();

	Optional<Customer> findByEmailAndPassword(String email, String password);

	Optional<Customer> findByEmail(String email);

	void save(Customer customer);

}
