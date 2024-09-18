package com.madhan.restapp.service;

import com.madhan.restapp.model.AdminProduct;
import java.util.List;

public interface AdminProductService {

	void insertProduct(AdminProduct product);

	AdminProduct findProductById(Long productId);

	void deleteProduct(Long productId);

	List<AdminProduct> findAllProducts();

	boolean purchaseProduct(Long productId, int quantity);

	void updateProduct(AdminProduct product);

	boolean updateProductQuantity(Long productId, int quantity);

    
}
