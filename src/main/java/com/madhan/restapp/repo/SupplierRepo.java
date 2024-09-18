package com.madhan.restapp.repo;

import java.util.List;

import com.madhan.restapp.model.Supplier;

public interface SupplierRepo {
	void save(Supplier supplier);
    Supplier findById(Long supplierId);
    Supplier findByUsername(String username);
    void update(Supplier supplier);
    void delete(Long supplierId);
    List<Supplier> findAll();

}
