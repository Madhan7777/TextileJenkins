package com.madhan.restapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.madhan.restapp.model.ProductRequest;
import com.madhan.restapp.service.ProductRequestService;

@RestController
@CrossOrigin("*")
@RequestMapping("/product-request")
public class ProductRequestController {

    @Autowired
    private ProductRequestService productRequestService;

    @PostMapping("/create")
    public ResponseEntity<String> createProductRequest(@RequestBody ProductRequest productRequest) {
        try {
            productRequest.setRequestDate(new Date()); 
            productRequestService.save(productRequest);
            return ResponseEntity.ok("Product request created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Creation Failure: " + e.getMessage());
        }
    }

    @PutMapping("/update/{requestId}")
    public ResponseEntity<String> updateProductRequest(@PathVariable("requestId") Long requestId,
                                                        @RequestBody ProductRequest updatedProductRequest) {
        try {
            ProductRequest existingProductRequest = productRequestService.findById(requestId);
            if (existingProductRequest == null) {
                return ResponseEntity.notFound().build();
            }
            updatedProductRequest.setRequestId(requestId);
            productRequestService.update(updatedProductRequest);
            return ResponseEntity.ok("Product request updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Update Failure: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{requestId}")
    public ResponseEntity<String> deleteProductRequest(@PathVariable("requestId") Long requestId) {
        try {
            productRequestService.delete(requestId);
            return ResponseEntity.ok("Product request deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Deletion Failure: " + e.getMessage());
        }
    }

    @GetMapping("/find/{requestId}")
    public ResponseEntity<ProductRequest> getProductRequestById(@PathVariable("requestId") Long requestId) {
        try {
            ProductRequest productRequest = productRequestService.findById(requestId);
            if (productRequest == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(productRequest);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductRequest>> getAllProductRequests() {
        try {
            List<ProductRequest> productRequests = productRequestService.findAll();
            return ResponseEntity.ok(productRequests);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
