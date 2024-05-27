package com.project.eplatform.service.implementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.project.eplatform.model.Product;
import com.project.eplatform.repository.ProductRepository;
import com.project.eplatform.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTests {
    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product();
        product.setProductID(1);
        product.setProductName("Test Product");
        product.setProductDesc("Test Desc");
        product.setPrice(1000L);
        product.setQuantityInStock(5);
    }

    @Test
    public void testCreateProduct() {
        when(productRepository.save(product)).thenReturn(product);

        ResponseEntity<?> response = productService.createProduct(product);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertInstanceOf(Map.class, response.getBody());

        Map<String, Object> responseBody = (Map<String, Object>) response.getBody();
        assertEquals(product, responseBody.get("response"));
        verify(productRepository, times(1)).save(product);
    }
}
