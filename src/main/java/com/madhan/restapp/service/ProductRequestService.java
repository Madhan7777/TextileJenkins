package com.madhan.restapp.service;

import java.util.List;

import com.madhan.restapp.model.ProductRequest;

public interface ProductRequestService {

	void save(ProductRequest productRequest);
    ProductRequest findById(Long requestId);
    void update(ProductRequest productRequest);
    void delete(Long requestId);
    List<ProductRequest> findAll();
}
