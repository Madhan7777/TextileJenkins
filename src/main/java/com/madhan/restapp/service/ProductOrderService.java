package com.madhan.restapp.service;

import java.util.List;

import com.madhan.restapp.model.ProductOrder;

public interface ProductOrderService {

	 void saveProductOrder(ProductOrder productOrder);
	    ProductOrder getProductOrderById(Long orderId);
	    void updateProductOrder(ProductOrder productOrder);
	    void deleteProductOrder(Long orderId);
	    List<ProductOrder> getAllProductOrders();
		boolean updateProductQuantity(Long productId, int quantity);
	    
	    

}
