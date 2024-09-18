package com.madhan.restapp.service;

import java.util.List;
import java.util.Optional;

import com.madhan.restapp.model.CartItem;

public interface CartItemService {

	Optional<CartItem> findById(Long id);

	List<CartItem> findAll();

	void deleteById(Long id);

	CartItem save(CartItem cartItem);

}
