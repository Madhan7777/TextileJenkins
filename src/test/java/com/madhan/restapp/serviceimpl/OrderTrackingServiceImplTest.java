package com.madhan.restapp.serviceimpl;

import com.madhan.restapp.model.OrderTracking;
import com.madhan.restapp.repo.OrderTrackingRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderTrackingServiceImplTest {

    @InjectMocks
    private OrderTrackingServiceImpl orderTrackingService;

    @Mock
    private OrderTrackingRepo orderTrackingRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    public void testSaveOrderTracking() {
        OrderTracking orderTracking = new OrderTracking();
        orderTrackingService.saveOrderTracking(orderTracking);

        verify(orderTrackingRepo, times(1)).save(orderTracking); 
    }

    @Test
    public void testGetOrderTrackingById() {
        Long trackingId = 1L;
        OrderTracking orderTracking = new OrderTracking();
        when(orderTrackingRepo.findById(trackingId)).thenReturn(orderTracking);

        OrderTracking result = orderTrackingService.getOrderTrackingById(trackingId);

        verify(orderTrackingRepo, times(1)).findById(trackingId);
        assertEquals(orderTracking, result); 
    }

    @Test
    public void testUpdateOrderTracking() {
        OrderTracking orderTracking = new OrderTracking();
        orderTrackingService.updateOrderTracking(orderTracking);

        verify(orderTrackingRepo, times(1)).update(orderTracking); 
    }

    @Test
    public void testDeleteOrderTracking() {
        Long trackingId = 1L;
        orderTrackingService.deleteOrderTracking(trackingId);

        verify(orderTrackingRepo, times(1)).delete(trackingId); 
    }

    @Test
    public void testGetAllOrderTrackings() {
        OrderTracking orderTracking = new OrderTracking();
        List<OrderTracking> orderTrackings = Collections.singletonList(orderTracking);
        when(orderTrackingRepo.findAll()).thenReturn(orderTrackings);

        List<OrderTracking> result = orderTrackingService.getAllOrderTrackings();

        verify(orderTrackingRepo, times(1)).findAll();
        assertEquals(1, result.size());
        assertEquals(orderTracking, result.get(0));
    }
}
