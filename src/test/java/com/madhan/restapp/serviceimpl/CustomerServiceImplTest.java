package com.madhan.restapp.serviceimpl;

import com.madhan.restapp.model.Customer;
import com.madhan.restapp.repo.CustomerRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepo customerRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    public void testAddCustomer() {
        Customer customer = new Customer();
        customerService.addCustomer(customer);

        verify(customerRepo, times(1)).save(customer); 
    }

    @Test
    public void testFindByEmail() {
        String email = "test@example.com";
        Customer customer = new Customer();
        when(customerRepo.findByEmail(email)).thenReturn(Optional.of(customer));

        Optional<Customer> result = customerService.findByEmail(email);

        verify(customerRepo, times(1)).findByEmail(email);
        assertTrue(result.isPresent());
        assertEquals(customer, result.get());
    }

    @Test
    public void testFindByEmailAndPassword() {
        String email = "test@example.com";
        String password = "password";
        Customer customer = new Customer();
        when(customerRepo.findByEmailAndPassword(email, password)).thenReturn(Optional.of(customer));

        Optional<Customer> result = customerService.findByEmailAndPassword(email, password);

        verify(customerRepo, times(1)).findByEmailAndPassword(email, password);
        assertTrue(result.isPresent());
        assertEquals(customer, result.get());
    }

    @Test
    public void testFindAllCustomers() {
        Customer customer = new Customer();
        List<Customer> customers = Collections.singletonList(customer);
        when(customerRepo.findAll()).thenReturn(customers);

        List<Customer> result = customerService.findAllCustomers();

        verify(customerRepo, times(1)).findAll();
        assertEquals(1, result.size());
        assertEquals(customer, result.get(0));
    }
}
