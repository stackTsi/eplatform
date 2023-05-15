package com.project.eplatform.service;

import com.project.eplatform.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface ProductService {
    ResponseEntity<?> createProduct(Product product);
    Collection<Product> list(int limit);
    Product getProduct(int product);
    Product updateProduct(Product product);
    Boolean deleteProduct(int product);
}
