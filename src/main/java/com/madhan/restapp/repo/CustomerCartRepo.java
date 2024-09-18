package com.madhan.restapp.repo;

import java.util.List;

import com.madhan.restapp.model.CustomerCart;

public interface CustomerCartRepo {

	CustomerCart save(CustomerCart CustomerCart);

	CustomerCart findById(Long id);

	List<CustomerCart> findAll();

	void deleteById(Long id);
}
