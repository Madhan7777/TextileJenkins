package com.madhan.restapp.serviceimpl;

import com.madhan.restapp.model.CartItem;
import com.madhan.restapp.model.CustomerCart;
import com.madhan.restapp.repo.CustomerCartRepo;
import com.madhan.restapp.service.CustomerCartService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerCartServiceImpl implements CustomerCartService {

    @Autowired
    private CustomerCartRepo CustomerCartRepository;

    @Override
    public CustomerCart saveCustomerCart(CustomerCart CustomerCart) {
        return CustomerCartRepository.save(CustomerCart);
    }

//    @Override
//    public CustomerCart getCustomerCartById(Long id) {
//        return CustomerCartRepository.findById(id);
//    }
    
    public CustomerCart findById(Long id) {
        return CustomerCartRepository.findById(id); 
    }

    @Override
    public List<CustomerCart> getAllCustomerCarts() {
        return CustomerCartRepository.findAll();
    }

    @Override
    public void deleteCustomerCart(Long id) {
        CustomerCartRepository.deleteById(id);
    }

	@Override
	public CustomerCart getCustomerCartById(Long id) {
		return CustomerCartRepository.findById(id);
	}

	@Override
	public CustomerCart addItemToCart(Long cartId, CartItem newItem) {
		return null;
	}
}
