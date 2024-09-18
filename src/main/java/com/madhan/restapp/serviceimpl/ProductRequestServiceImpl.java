package com.madhan.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhan.restapp.model.ProductRequest;
import com.madhan.restapp.repo.ProductRequestRepo;
import com.madhan.restapp.service.ProductRequestService;

@Service
public class ProductRequestServiceImpl implements ProductRequestService {

    private final ProductRequestRepo productRequestRepo;

    @Autowired
    public ProductRequestServiceImpl(ProductRequestRepo productRequestRepo) {
        this.productRequestRepo = productRequestRepo;
    }

    @Override
    public void save(ProductRequest productRequest) {
        productRequestRepo.save(productRequest);
    }

    @Override
    public ProductRequest findById(Long requestId) {
        return productRequestRepo.findById(requestId);
    }

    @Override
    public void update(ProductRequest productRequest) {
        productRequestRepo.update(productRequest);
    }

    @Override
    public void delete(Long requestId) {
        productRequestRepo.delete(requestId);
    }

    @Override
    public List<ProductRequest> findAll() {
        return productRequestRepo.findAll();
    }
}
