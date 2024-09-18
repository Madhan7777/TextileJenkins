package com.madhan.restapp.serviceimpl;

import com.madhan.restapp.model.ProductOrder;
import com.madhan.restapp.repo.ProductOrderRepo;
import com.madhan.restapp.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    private final ProductOrderRepo productOrderRepo;

    @Autowired
    public ProductOrderServiceImpl(ProductOrderRepo productOrderRepo) {
        this.productOrderRepo = productOrderRepo;
    }

    @Override
    public void saveProductOrder(ProductOrder productOrder) {
        productOrderRepo.save(productOrder);
        
    }

    @Override
    public ProductOrder getProductOrderById(Long orderId) {
        return productOrderRepo.findById(orderId);
    }

    @Override
    public void updateProductOrder(ProductOrder productOrder) {
        productOrderRepo.update(productOrder);
    }

    @Override
    public void deleteProductOrder(Long orderId) {
        productOrderRepo.delete(orderId);
    }

    @Override
    public List<ProductOrder> getAllProductOrders() {
        return productOrderRepo.findAll();
    }
    
    @Override
    public boolean updateProductQuantity(Long productId, int quantity) {
        return true; 
    }
}



