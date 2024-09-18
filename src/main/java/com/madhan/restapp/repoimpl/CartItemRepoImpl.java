package com.madhan.restapp.repoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madhan.restapp.model.CartItem;
import com.madhan.restapp.repo.CartItemRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CartItemRepoImpl implements CartItemRepo {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public CartItem save(CartItem cartItem) {
        try {
            if (cartItem.getId() == null) {
                entityManager.persist(cartItem);
            } else {
                entityManager.merge(cartItem);
            }
            return cartItem;
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }

    @Override
    public Optional<CartItem> findById(Long id) {
        try {
            CartItem cartItem = entityManager.find(CartItem.class, id);
            return Optional.ofNullable(cartItem);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty(); 
        }
    }

    @Override
    public List<CartItem> findAll() {
        try {
            return entityManager.createQuery("from CartItem", CartItem.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        try {
            CartItem cartItem = entityManager.find(CartItem.class, id);
            if (cartItem != null) {
                entityManager.remove(cartItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
}
