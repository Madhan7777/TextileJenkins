package com.madhan.restapp.serviceimpl;

import com.madhan.restapp.model.AdminProduct;
import com.madhan.restapp.repo.AdminProductRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AdminProductServiceImplTest {

    @InjectMocks
    private AdminProductServiceImpl productService;

    @Mock
    private AdminProductRepo productRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    public void testInsertProduct() {
        AdminProduct product = new AdminProduct();

        productService.insertProduct(product);

        verify(productRepo, times(1)).save(product); 
    }

    @Test
    public void testUpdateProduct() {
        AdminProduct product = new AdminProduct();
        
        productService.updateProduct(product);

        verify(productRepo, times(1)).update(product); 
    }

    @Test
    public void testFindAllProducts() {
        AdminProduct product = new AdminProduct();
        List<AdminProduct> products = Collections.singletonList(product);
        when(productRepo.findAll()).thenReturn(products); 
        List<AdminProduct> result = productService.findAllProducts();

        // Assert
        verify(productRepo, times(1)).findAll(); 
        assertEquals(1, result.size()); 
        assertEquals(product, result.get(0)); 
    }

    @Test
    public void testDeleteProduct() {
        Long productId = 1L;

        productService.deleteProduct(productId);

        verify(productRepo, times(1)).delete(productId); 
    }

    @Test
    public void testFindProductById() {
        Long productId = 1L;
        AdminProduct product = new AdminProduct();
        when(productRepo.findById(productId)).thenReturn(product); 

        AdminProduct result = productService.findProductById(productId);

        verify(productRepo, times(1)).findById(productId);
        assertEquals(product, result); 
    }
}
