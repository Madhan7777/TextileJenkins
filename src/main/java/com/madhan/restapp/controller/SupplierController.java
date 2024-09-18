package com.madhan.restapp.controller;

import com.madhan.restapp.model.Supplier;
import com.madhan.restapp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
@CrossOrigin("*")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/add")
    public ResponseEntity<String> addSupplier(@RequestBody Supplier supplier) {
        try {
            supplierService.saveSupplier(supplier);
            return ResponseEntity.ok("Supplier added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to add supplier");
        }
    }

    @GetMapping("/find/{supplierId}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long supplierId) {
        Supplier supplier = supplierService.findSupplierById(supplierId);
        return supplier != null ? ResponseEntity.ok(supplier) : ResponseEntity.notFound().build();
    }

    @GetMapping("/findByUsername/{username}")
    public ResponseEntity<Supplier> getSupplierByUsername(@PathVariable String username) {
        Supplier supplier = supplierService.findSupplierByUsername(username);
        return supplier != null ? ResponseEntity.ok(supplier) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateSupplier(@RequestBody Supplier supplier) {
        try {
            supplierService.updateSupplier(supplier);
            return ResponseEntity.ok("Supplier updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to update supplier");
        }
    }

    @DeleteMapping("/delete/{supplierId}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Long supplierId) {
        try {
            supplierService.deleteSupplier(supplierId);
            return ResponseEntity.ok("Supplier deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to delete supplier");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.findAllSuppliers();
        return ResponseEntity.ok(suppliers);
    }
}
