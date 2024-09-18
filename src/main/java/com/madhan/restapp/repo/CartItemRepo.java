package com.madhan.restapp.repo;

import java.util.List;
import java.util.Optional;

import com.madhan.restapp.model.CartItem;

public interface CartItemRepo {

	CartItem save(CartItem cartItem);

	Optional<CartItem> findById(Long id);

	List<CartItem> findAll();

	void deleteById(Long id);
}
