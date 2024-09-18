package com.madhan.restapp.repo;

import java.util.List;

import com.madhan.restapp.model.AdminProduct;

public interface AdminProductRepo {

	 void save(AdminProduct product);
	    AdminProduct findById(Long productId);
	    void update(AdminProduct product);
	    void delete(Long productId);
	    List<AdminProduct> findAll();

}
