package com.madhan.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhan.restapp.model.OrderTracking;
import com.madhan.restapp.repo.OrderTrackingRepo;
import com.madhan.restapp.service.OrderTrackingService;

@Service
public class OrderTrackingServiceImpl implements OrderTrackingService{

    private final OrderTrackingRepo orderTrackingRepo;

    @Autowired
    public OrderTrackingServiceImpl(OrderTrackingRepo orderTrackingRepo) {
        this.orderTrackingRepo = orderTrackingRepo;
    }
   
	@Override
	public void saveOrderTracking(OrderTracking orderTracking) {
        orderTrackingRepo.save(orderTracking);
		
	}

	@Override
	public OrderTracking getOrderTrackingById(Long trackingId) {
        return orderTrackingRepo.findById(trackingId);

	}

	@Override
	public void updateOrderTracking(OrderTracking orderTracking) {
        orderTrackingRepo.update(orderTracking);
		
	}

	@Override
	public void deleteOrderTracking(Long trackingId) {
        orderTrackingRepo.delete(trackingId);
		
	}

	@Override
	public List<OrderTracking> getAllOrderTrackings() {
        return orderTrackingRepo.findAll();

	}

}
