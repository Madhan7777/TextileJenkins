package com.madhan.restapp.repoimpl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madhan.restapp.model.AdminProduct;
import com.madhan.restapp.repo.AdminProductRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AdminProductRepoImpl implements AdminProductRepo {

	@Autowired
    private EntityManager entityManager;
	
	@Override
	public void save(AdminProduct product) {
		 try {
	            entityManager.persist(product);
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to save product", e);
	        }		
	}

	@Override
	public AdminProduct findById(Long productId) {
		 try {
	            return entityManager.find(AdminProduct.class, productId);
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to find product by ID", e);
	        }
	}

//	@Override
//	public void update(AdminProduct product) {
//		 try {
//	            entityManager.merge(product);
//	        } 
//		 catch (Exception e) {
//	            throw new RuntimeException("Failed to update product", e);
//	        }		
//	}
	
	 @Override
	    public void update(AdminProduct product) {
	        try {
	            if (entityManager.contains(product)) {
	                entityManager.merge(product);
	            } else {
	                throw new RuntimeException("AdminProduct not found for update");
	            }
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to update AdminProduct", e);
	        }
	    }

	@Override
	public void delete(Long productId) {
		 try {
	            AdminProduct product = findById(productId);
	            if (product != null) {
	                entityManager.remove(product);
	            }
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to delete product", e);
	        }		
	}

	@Override
	public List<AdminProduct> findAll() {
		try {
            Query<AdminProduct> query = (Query<AdminProduct>) entityManager.createQuery("from AdminProduct");
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Failed to find all products", e);
        }
    
	}
	

}
