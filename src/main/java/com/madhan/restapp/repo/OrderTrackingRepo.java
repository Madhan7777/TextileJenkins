package com.madhan.restapp.repo;

import java.util.List;

import com.madhan.restapp.model.OrderTracking;

public interface OrderTrackingRepo {

	void save(OrderTracking orderTracking);
    OrderTracking findById(Long trackingId);
    void update(OrderTracking orderTracking);
    void delete(Long trackingId);
    List<OrderTracking> findAll();
}
