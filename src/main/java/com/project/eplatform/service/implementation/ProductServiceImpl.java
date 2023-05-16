package com.project.eplatform.service.implementation;

import com.project.eplatform.model.Product;
import com.project.eplatform.repository.ProductRepository;
import com.project.eplatform.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ResponseEntity<?> createProduct(Product product) {
        Map<String,Object> response = new HashMap<>();
        log.info("Adding a new product: {}", product.getProductName());

        productRepository.save(product);
        response.put("response",product);
        return ResponseEntity.ok(response);
    }

    @Override
    public Collection<Product> list(int limit) {
        log.info("Fetching list of products:");
        return productRepository.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Product getProduct(int productID) {
        log.info("Fetching product by ID {}",productID);
        return productRepository.findById(productID).orElse(null);
    }

    @Override
    public Product updateProduct(int productID, Product product) {
        log.info("Updating productID {} information",productID);
        Product existingProduct = productRepository.findById(productID).orElse(null);
        if(existingProduct == null){
            return null;
        }
        if(product.getProductName() != null){
            existingProduct.setProductName(product.getProductName());
        }
        if(product.getProductDesc() != null){
            existingProduct.setProductDesc(product.getProductDesc());
        }
        if(product.getPrice() != null){
            existingProduct.setPrice(product.getPrice());
        }
        if(product.getCategory() != null){
            existingProduct.setCategory(product.getCategory());
        }
        return productRepository.save(existingProduct);
    }

    @Override
    public Boolean deleteProduct(int productID) {
        log.info("Deleting product by ID: {}",productID);
        Optional<Product> product = productRepository.findById(productID);
        if(product.isPresent()){
            productRepository.deleteById(productID);
            log.info("Product deletion was a success!");
            return TRUE;
        } else {
            log.warn("Error! Product ID {} not found!", productID);
            return FALSE;
        }
    }
}