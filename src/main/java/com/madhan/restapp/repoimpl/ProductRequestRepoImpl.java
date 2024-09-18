package com.madhan.restapp.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.madhan.restapp.model.ProductRequest;
import com.madhan.restapp.repo.ProductRequestRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
@Transactional
public class ProductRequestRepoImpl implements ProductRequestRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(ProductRequest productRequest) {
        try {
            entityManager.persist(productRequest);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save product request", e);
        }
    }

    @Override
    public ProductRequest findById(Long requestId) {
        try {
            return entityManager.find(ProductRequest.class, requestId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to find product request by ID", e);
        }
    }

    @Override
    public void update(ProductRequest productRequest) {
        try {
            entityManager.merge(productRequest);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update product request", e);
        }
    }

    @Override
    public void delete(Long requestId) {
        try {
            ProductRequest productRequest = findById(requestId);
            if (productRequest != null) {
                entityManager.remove(productRequest);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete product request", e);
        }
    }

    @Override
    public List<ProductRequest> findAll() {
        try {
            Query query = entityManager.createQuery("from ProductRequest", ProductRequest.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Failed to find all product requests", e);
        }
    }
}
