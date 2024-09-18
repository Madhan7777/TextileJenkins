package com.madhan.restapp.controller;

import com.madhan.restapp.model.ProductOrder;
import com.madhan.restapp.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/orders")
public class ProductOrderController {

    @Autowired
    private ProductOrderService productOrderService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody ProductOrder productOrder) {
        try {
            productOrderService.saveProductOrder(productOrder);
            return ResponseEntity.ok("Order created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Order creation failed");
        }
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable("orderId") Long orderId) {
        try {
            productOrderService.deleteProductOrder(orderId);
            return ResponseEntity.ok("Order deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Order deletion failed");
        }
    }

    @GetMapping("/find/{orderId}")
    public ResponseEntity<ProductOrder> findOrderById(@PathVariable("orderId") Long orderId) {
        try {
            ProductOrder order = productOrderService.getProductOrderById(orderId);
            if (order != null) {
                return ResponseEntity.ok(order);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductOrder>> findAllOrders() {
        try {
            List<ProductOrder> orders = productOrderService.getAllProductOrders();
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/summary")
    public ResponseEntity<Map<String, Integer>> getOrderSummaryByDate() {
        try {
            List<ProductOrder> orders = productOrderService.getAllProductOrders();
            Map<String, Integer> summary = orders.stream()
                .collect(Collectors.groupingBy(ProductOrder::getOrderDate, Collectors.summingInt(e -> 1)));
            return ResponseEntity.ok(summary);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PostMapping("/updateProductQuantity")
    public ResponseEntity<String> updateProductQuantity(
            @RequestParam("productId") Long productId,
            @RequestParam("quantity") int quantity) {

        boolean success = productOrderService.updateProductQuantity(productId, quantity);
        if (success) {
            return ResponseEntity.ok("Product quantity updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient stock or product not found");
        }
    }
}


