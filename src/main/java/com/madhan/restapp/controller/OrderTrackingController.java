package com.madhan.restapp.controller;

import com.madhan.restapp.model.OrderTracking;
import com.madhan.restapp.service.OrderTrackingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderTracking")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderTrackingController {

    @Autowired
    private OrderTrackingService orderTrackingService;
    
   

    @PostMapping("/save")
    public ResponseEntity<String> saveOrderTracking(@RequestBody OrderTracking orderTracking) {
        try {
            orderTrackingService.saveOrderTracking(orderTracking);
            return ResponseEntity.ok("OrderTracking saved successfully");
            
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving OrderTracking");
        }
    }

 
    @GetMapping("/{trackingId}")
    public ResponseEntity<OrderTracking> getOrderTrackingById(@PathVariable Long trackingId) {
        OrderTracking orderTracking = orderTrackingService.getOrderTrackingById(trackingId);
        if (orderTracking != null) {
            return ResponseEntity.ok(orderTracking);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateOrderTracking(@RequestBody OrderTracking orderTracking) {
        try {
            orderTrackingService.updateOrderTracking(orderTracking);
            return ResponseEntity.ok("OrderTracking updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating OrderTracking");
        }
    }

    @DeleteMapping("/delete/{trackingId}")
    public ResponseEntity<String> deleteOrderTracking(@PathVariable Long trackingId) {
        try {
            orderTrackingService.deleteOrderTracking(trackingId);
            return ResponseEntity.ok("OrderTracking deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting OrderTracking");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderTracking>> getAllOrderTrackings() {
        List<OrderTracking> orderTrackings = orderTrackingService.getAllOrderTrackings();
        return ResponseEntity.ok(orderTrackings);
    }
    
//    @GetMapping("/{trackingId}")
//    public ResponseEntity<OrderTracking> getProductById(@PathVariable Long productId) {
//        OrderTracking orderTracking = orderTrackingService.getOrderTrackingById(productId);
//        if (orderTracking != null) {
//            return ResponseEntity.ok(orderTracking);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }
}
