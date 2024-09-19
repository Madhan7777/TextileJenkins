package com.madhan.restapp.serviceimpl;

import com.madhan.restapp.model.ProductOrder;
import com.madhan.restapp.repo.ProductOrderRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductOrderServiceImplTest {

    @InjectMocks
    private ProductOrderServiceImpl productOrderService;

    @Mock
    private ProductOrderRepo productOrderRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    public void testSaveProductOrder() {
        ProductOrder productOrder = new ProductOrder();
        productOrderService.saveProductOrder(productOrder);

        verify(productOrderRepo, times(1)).save(productOrder); 
    }

    @Test
    public void testGetProductOrderById() {
        Long orderId = 1L;
        ProductOrder productOrder = new ProductOrder();
        when(productOrderRepo.findById(orderId)).thenReturn(productOrder);

        ProductOrder result = productOrderService.getProductOrderById(orderId);

        verify(productOrderRepo, times(1)).findById(orderId);
        assertEquals(productOrder, result); 
    }

    @Test
    public void testUpdateProductOrder() {
        ProductOrder productOrder = new ProductOrder();
        productOrderService.updateProductOrder(productOrder);

        verify(productOrderRepo, times(1)).update(productOrder); 
    }

    @Test
    public void testDeleteProductOrder() {
        Long orderId = 1L;
        productOrderService.deleteProductOrder(orderId);

        verify(productOrderRepo, times(1)).delete(orderId); 
    }

    @Test
    public void testGetAllProductOrders() {
        ProductOrder productOrder = new ProductOrder();
        List<ProductOrder> productOrders = Collections.singletonList(productOrder);
        when(productOrderRepo.findAll()).thenReturn(productOrders);

        List<ProductOrder> result = productOrderService.getAllProductOrders();

        verify(productOrderRepo, times(1)).findAll();
        assertEquals(1, result.size());
        assertEquals(productOrder, result.get(0));
    }

    @Test
    public void testUpdateProductQuantity() {
        Long productId = 1L;
        int quantity = 5;

        boolean result = productOrderService.updateProductQuantity(productId, quantity);

        assertTrue(result);  
    }
}
