package com.madhan.restapp.service;

import java.util.List;

import com.madhan.restapp.model.Supplier;

public interface SupplierService {

	void saveSupplier(Supplier supplier);
    Supplier findSupplierById(Long supplierId);
    Supplier findSupplierByUsername(String username);
    void updateSupplier(Supplier supplier);
    void deleteSupplier(Long supplierId);
    List<Supplier> findAllSuppliers();
}
