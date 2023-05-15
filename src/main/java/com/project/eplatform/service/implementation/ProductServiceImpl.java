package com.project.eplatform.service.implementation;

import com.project.eplatform.model.Product;
import com.project.eplatform.repository.ProductRepository;
import com.project.eplatform.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<?> createProduct(Product product) {
        Map<String,Object> response = new HashMap<>();
        log.info("Adding a new product: {}", product.getProductName());

        return null;
    }

    @Override
    public Collection<Product> list(int limit) {
        return null;
    }

    @Override
    public Product getProduct(int product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public Boolean deleteProduct(int product) {
        return null;
    }
}
