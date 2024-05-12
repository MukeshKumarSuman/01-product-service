package com.nps.controllers;

import com.nps.exception.ProductNotFoundException;
import com.nps.models.Product;
import com.nps.services.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void valid_GetProductById() throws ProductNotFoundException {
        Product p = new Product();
        when(productService.getProductById(anyLong())).thenReturn(p);
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void replaceProduct() {
    }

    @Test
    void createProduct() {
    }
}