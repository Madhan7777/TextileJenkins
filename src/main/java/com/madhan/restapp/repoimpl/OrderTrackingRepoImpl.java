package com.madhan.restapp.repoimpl;

import java.util.List;


import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madhan.restapp.model.OrderTracking;
import com.madhan.restapp.repo.OrderTrackingRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class OrderTrackingRepoImpl implements OrderTrackingRepo {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(OrderTracking orderTracking) {
        try {
            entityManager.persist(orderTracking);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save order tracking", e);
        }
    }

    @Override
    public OrderTracking findById(Long trackingId) {
        try {
            return entityManager.find(OrderTracking.class, trackingId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to find order tracking by ID", e);
        }
    }

    @Override
    public void update(OrderTracking orderTracking) {
        try {
            entityManager.merge(orderTracking);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update order tracking", e);
        }
    }

    @Override
    public void delete(Long trackingId) {
        try {
            OrderTracking orderTracking = findById(trackingId);
            if (orderTracking != null) {
                entityManager.remove(orderTracking);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete order tracking", e);
        }
    }

    @Override
    public List<OrderTracking> findAll() {
        try {
            Query<OrderTracking> query = (Query<OrderTracking>) entityManager.createQuery("from OrderTracking");
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Failed to find all order trackings", e);
        }
    }
}
