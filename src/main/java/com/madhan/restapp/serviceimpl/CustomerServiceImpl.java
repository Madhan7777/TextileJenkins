package com.madhan.restapp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhan.restapp.model.Customer;
import com.madhan.restapp.repo.CustomerRepo;
import com.madhan.restapp.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
    private CustomerRepo customerRepository;
	
	@Override
	public void addCustomer(Customer customer) {
        customerRepository.save(customer);
		
	}

	@Override
	public Optional<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
	}

	@Override
	public Optional<Customer> findByEmailAndPassword(String email, String password) {
        return customerRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
	}

}
