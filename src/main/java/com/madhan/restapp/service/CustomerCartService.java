package com.madhan.restapp.service;

import java.util.List;

import com.madhan.restapp.model.CartItem;
import com.madhan.restapp.model.CustomerCart;

public interface CustomerCartService {

	CustomerCart saveCustomerCart(CustomerCart customerCart);

	CustomerCart addItemToCart(Long cartId, CartItem newItem);

	void deleteCustomerCart(Long id);

	CustomerCart getCustomerCartById(Long id);

	List<CustomerCart> getAllCustomerCarts();

}
