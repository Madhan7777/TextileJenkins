package com.madhan.restapp.serviceimpl;

import com.madhan.restapp.model.Supplier;
import com.madhan.restapp.repo.SupplierRepo;
import com.madhan.restapp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    @Override
    public void saveSupplier(Supplier supplier) {
        supplierRepo.save(supplier);
    }

    @Override
    public Supplier findSupplierById(Long supplierId) {
        return supplierRepo.findById(supplierId);
    }

    @Override
    public Supplier findSupplierByUsername(String username) {
        return supplierRepo.findByUsername(username);
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        supplierRepo.update(supplier);
    }

    @Override
    public void deleteSupplier(Long supplierId) {
        supplierRepo.delete(supplierId);
    }

    @Override
    public List<Supplier> findAllSuppliers() {
        return supplierRepo.findAll();
    }
}
