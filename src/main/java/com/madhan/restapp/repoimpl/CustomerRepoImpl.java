package com.madhan.restapp.repoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.madhan.restapp.model.Customer;
import com.madhan.restapp.repo.CustomerRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CustomerRepoImpl implements CustomerRepo{

	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public List<Customer> findAll() {
		 String jpql = "SELECT c FROM Customer c";
	        return entityManager.createQuery(jpql, Customer.class).getResultList();
	}

	@Override
	public Optional<Customer> findByEmailAndPassword(String email, String password) {
		 String jpql = "SELECT c FROM Customer c WHERE c.email = :email AND c.password = :password";
	        TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
	        query.setParameter("email", email);
	        query.setParameter("password", password);
	        return query.getResultList().stream().findFirst();
	}

	@Override
	public Optional<Customer> findByEmail(String email) {
		 String jpql = "SELECT c FROM Customer c WHERE c.email = :email";
	        TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
	        query.setParameter("email", email);
	        return query.getResultList().stream().findFirst();
	}

	@Override
	public void save(Customer customer) {
		 if (customer.getCustomerId() == null) {
	            entityManager.persist(customer);
	        } else {
	            entityManager.merge(customer);
	        }		
	}

}
