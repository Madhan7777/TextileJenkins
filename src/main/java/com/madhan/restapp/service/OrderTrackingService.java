package com.madhan.restapp.service;

import java.util.List;

import com.madhan.restapp.model.OrderTracking;

public interface OrderTrackingService {

	void saveOrderTracking(OrderTracking orderTracking);
    OrderTracking getOrderTrackingById(Long trackingId);
    void updateOrderTracking(OrderTracking orderTracking);
    void deleteOrderTracking(Long trackingId);
    List<OrderTracking> getAllOrderTrackings();
}
