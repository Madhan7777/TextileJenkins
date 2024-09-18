package com.madhan.restapp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhan.restapp.model.AdminProduct;
import com.madhan.restapp.repo.AdminProductRepo;
import com.madhan.restapp.service.AdminProductService;

@Service
public class AdminProductServiceImpl implements AdminProductService {

	@Autowired
	private final AdminProductRepo repository;
	
	public AdminProductServiceImpl(AdminProductRepo repository) {
        this.repository = repository;
    }

	
	@Override
	public void insertProduct(AdminProduct product) {
        repository.save(product);
		
	}

	@Override
	public AdminProduct findProductById(Long productId) {
        return repository.findById(productId);
	}

	@Override
	public void deleteProduct(Long productId) {
        repository.delete(productId);
		
	}

	@Override
	public List<AdminProduct> findAllProducts() {
        return repository.findAll();

	}

	@Override
	public boolean purchaseProduct(Long productId, int quantity) {
		 AdminProduct product = repository.findById(productId);
	        if (product != null && product.getQuantity() >= quantity) {
	            product.setQuantity(product.getQuantity() - quantity);
	            repository.update(product);
	            return true;
	        }
	        return false;
	    }
	

	@Override
	public void updateProduct(AdminProduct product) {
        repository.update(product);
		
	}


	@Override
	public boolean updateProductQuantity(Long productId, int quantity) {
		 Optional<AdminProduct> optionalProduct = Optional.of(repository.findById(productId));
	        if (optionalProduct.isPresent()) {
	            AdminProduct product = optionalProduct.get();
	            int currentQuantity = product.getQuantity();
	            if (currentQuantity >= quantity) {
	                product.setQuantity(currentQuantity - quantity);
	                repository.save(product);
	                return true;
	            } else {
	                return false; 
	            }
	        } else {
	            return false; 
	        }
	    }
	

}
