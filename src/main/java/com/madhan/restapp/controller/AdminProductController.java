package com.madhan.restapp.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.madhan.restapp.model.AdminProduct;
import com.madhan.restapp.service.AdminProductService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/AdminProduct")
public class AdminProductController {

    @Autowired
    private AdminProductService service;

    @PostMapping(value = "/insertSellerProduct", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> insertProduct(
            @RequestParam("productName") String productName,
            @RequestParam("imageProduct") MultipartFile file,
            @RequestParam("description") String description,
            @RequestParam("price") int price,
            @RequestParam("category") String category,
            @RequestParam("quantity") int quantity,
            @RequestParam("brand") String brand,
            @RequestParam("material") String material,
            @RequestParam("color") String color,
            @RequestParam("pattern") String pattern,
            @RequestParam("size") String size,
            @RequestParam("gender") String gender,
            @RequestParam("careInstructions") String careInstructions) throws IOException {

        AdminProduct product = new AdminProduct();
        product.setProductName(productName);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategory(category);
        product.setQuantity(quantity);
        product.setBrand(brand);
        product.setMaterial(material);
        product.setColor(color);
        product.setPattern(pattern);
        product.setSize(size);
        product.setGender(gender);
        product.setCareInstructions(careInstructions);
        product.setImageName(file.getOriginalFilename());
        product.setImageType(file.getContentType());
        product.setProductImage(file.getBytes());

        try {
            service.insertProduct(product);
            return ResponseEntity.ok("Product inserted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Insertion Failure");
        }
    }

    @GetMapping("/findProductById/{productId}")
    public ResponseEntity<AdminProduct> findProductById(@PathVariable("productId") Long productId) {
        AdminProduct product = service.findProductById(productId);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/findProdImage/{id}")
    public ResponseEntity<ByteArrayResource> findProductImage(@PathVariable("id") Long productId) {
        try {
            AdminProduct product = service.findProductById(productId);
            if (product != null && product.getProductImage() != null) {
                byte[] image = product.getProductImage();
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(product.getImageType()))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + product.getImageName() + "\"")
                        .body(new ByteArrayResource(image));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/updateSellerProduct")
    public ResponseEntity<String> updateProduct(
            @RequestParam("productId") Long productId,
            @RequestParam("productName") String productName,
            @RequestParam("description") String description,
            @RequestParam("price") int price,
            @RequestParam("category") String category,
            @RequestParam("quantity") int quantity,
            @RequestParam("brand") String brand,
            @RequestParam("material") String material,
            @RequestParam("color") String color,
            @RequestParam("pattern") String pattern,
            @RequestParam("size") String size,
            @RequestParam("gender") String gender,
            @RequestParam("careInstructions") String careInstructions,
            @RequestParam(value = "imageProduct", required = false) MultipartFile imageProduct) {

        try {
            AdminProduct product = service.findProductById(productId);
            if (product != null) {
                product.setProductName(productName);
                product.setDescription(description);
                product.setPrice(price);
                product.setCategory(category);
                product.setQuantity(quantity);
                product.setBrand(brand);
                product.setMaterial(material);
                product.setColor(color);
                product.setPattern(pattern);
                product.setSize(size);
                product.setGender(gender);
                product.setCareInstructions(careInstructions);
                if (imageProduct != null) {
                    product.setImageName(imageProduct.getOriginalFilename());
                    product.setImageType(imageProduct.getContentType());
                    product.setProductImage(imageProduct.getBytes());
                }
                service.updateProduct(product);
                return ResponseEntity.ok("Product updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update Failure");
        }
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("productId") Long productId) {
        try {
            service.deleteProduct(productId);
            return ResponseEntity.ok("Product deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Deletion Failure");
        }
    }

    @GetMapping("/findAllProduct")
    public ResponseEntity<List<AdminProduct>> findAllProduct() {
        List<AdminProduct> products = service.findAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseProduct(
            @RequestParam("productId") Long productId,
            @RequestParam("quantity") int quantity) {

        boolean success = service.purchaseProduct(productId, quantity);
        if (success) {
            return ResponseEntity.ok("Product purchased successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient stock or product not found");
        }
    }
    
    @PostMapping("/updateProductQuantity")
    public ResponseEntity<String> updateProductQuantity(
            @RequestParam("productId") Long productId,
            @RequestParam("quantity") int quantity) {

        boolean success = service.updateProductQuantity(productId, quantity);
        if (success) {
            return ResponseEntity.ok("Product quantity updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient stock or product not found");
        }
    }
}
