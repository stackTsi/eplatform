package com.project.eplatform.service;

import com.project.eplatform.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface ProductService {
    ResponseEntity<?> createProduct(Product request);
    Collection<Product> list(int limit);
    Collection<Product> listIPad(int limit);
    Collection<Product> listIPhone(int limit);
    Collection<Product> listMac(int limit);
    Product getProduct(int productID);
    Product updateProduct(int productID,Product product);
    Boolean deleteProduct(int productID);
}
