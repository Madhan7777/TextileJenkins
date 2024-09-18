package com.madhan.restapp.controller;

import com.madhan.restapp.model.CartItem;
import com.madhan.restapp.model.CustomerCart;
import com.madhan.restapp.service.CustomerCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/CustomerCart")
public class CustomerCartController {

    @Autowired
    private CustomerCartService CustomerCartService;

    @PostMapping("/insertCustomerCart")
    public ResponseEntity<String> createCustomerCart(@RequestBody CustomerCart CustomerCart) {
        try {
            CustomerCartService.saveCustomerCart(CustomerCart);
            return ResponseEntity.ok("Customer cart created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Creation Failure: " + e.getMessage());
        }
    }

    @PostMapping("/addItem/{cartId}")
    public ResponseEntity<CustomerCart> addItemToCart(@PathVariable Long cartId, @RequestBody CartItem newItem) {
        try {
            CustomerCart updatedCart = CustomerCartService.addItemToCart(cartId, newItem);
            return ResponseEntity.ok(updatedCart);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/deleteCustomerCart/{id}")
    public ResponseEntity<String> deleteCustomerCart(@PathVariable Long id) {
        try {
            CustomerCartService.deleteCustomerCart(id);
            return ResponseEntity.ok("Customer cart deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Deletion Failure: " + e.getMessage());
        }
    }

    @GetMapping("/findCustomerCartById/{id}")
    public ResponseEntity<CustomerCart> getCustomerCartById(@PathVariable Long id) {
        try {
            CustomerCart CustomerCart = CustomerCartService.getCustomerCartById(id);
            return ResponseEntity.ok(CustomerCart);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findAllCustomerCarts")
    public ResponseEntity<List<CustomerCart>> getAllCustomerCarts() {
        try {
            List<CustomerCart> CustomerCarts = CustomerCartService.getAllCustomerCarts();
            return ResponseEntity.ok(CustomerCarts);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
