package com.madhan.restapp.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madhan.restapp.model.CustomerCart;
import com.madhan.restapp.repo.CustomerCartRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CustomerCartRepoImpl implements CustomerCartRepo {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public CustomerCart save(CustomerCart CustomerCart) {
        try {
            if (CustomerCart.getId() == null) {
                entityManager.persist(CustomerCart); 
            } else {
                entityManager.merge(CustomerCart); 
            }
            return CustomerCart;
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }
    
    

//    @Override
    public CustomerCart findById(Long id) {
		return null;
//        try {
//            CustomerCart CustomerCart = entityManager.find(CustomerCart.class, id);
//            return Optional.ofNullable(CustomerCart);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Optional.empty(); // Or handle the exception as needed
//        }
    }

    @Override
    public List<CustomerCart> findAll() {
        try {
            return entityManager.createQuery("from CustomerCart", CustomerCart.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        try {
            CustomerCart CustomerCart = entityManager.find(CustomerCart.class, id);
            if (CustomerCart != null) {
                entityManager.remove(CustomerCart);
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
}
