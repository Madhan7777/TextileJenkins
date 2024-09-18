package com.madhan.restapp.serviceimpl;

import com.madhan.restapp.model.CartItem;
import com.madhan.restapp.repo.CartItemRepo;
import com.madhan.restapp.service.CartItemService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepo cartItemRepo;

    public CartItem save(CartItem cartItem) {
        return cartItemRepo.save(cartItem);
    }

    
    public Optional<CartItem> findById(Long id) {
        return cartItemRepo.findById(id);
    }

    public List<CartItem> findAll() {
        return cartItemRepo.findAll();
    }

    public void deleteById(Long id) {
        cartItemRepo.deleteById(id);
    }
}
