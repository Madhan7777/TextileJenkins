package com.madhan.restapp.repo;

import java.util.List;

import com.madhan.restapp.model.ProductOrder;

public interface ProductOrderRepo {

	void save(ProductOrder productOrder);
    ProductOrder findById(Long orderId);
    void update(ProductOrder productOrder);
    void delete(Long orderId);
    List<ProductOrder> findAll();
}
