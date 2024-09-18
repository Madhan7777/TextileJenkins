package com.madhan.restapp.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madhan.restapp.model.ProductOrder;
import com.madhan.restapp.repo.ProductOrderRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductOrderRepoImpl implements ProductOrderRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(ProductOrder productOrder) {
        try {
            entityManager.persist(productOrder);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save product order", e);
        }
    }

    @Override
    public ProductOrder findById(Long orderId) {
        try {
            return entityManager.find(ProductOrder.class, orderId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to find product order by ID", e);
        }
    }

    @Override
    public void update(ProductOrder productOrder) {
        try {
            if (entityManager.contains(productOrder)) {
                entityManager.merge(productOrder);
            } else {
                throw new RuntimeException("ProductOrder not found for update");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to update product order", e);
        }
    }

    @Override
    public void delete(Long orderId) {
        try {
            ProductOrder productOrder = findById(orderId);
            if (productOrder != null) {
                entityManager.remove(productOrder);
            } else {
                throw new RuntimeException("ProductOrder not found for deletion");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete product order", e);
        }
    }

    @Override
    public List<ProductOrder> findAll() {
        try {
            return entityManager.createQuery("SELECT p FROM ProductOrder p", ProductOrder.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Failed to find all product orders", e);
        }
    }
}
