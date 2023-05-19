package com.project.eplatform.controller;

import com.project.eplatform.model.Product;
import com.project.eplatform.service.ProductService;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody Product request){
        return productService.createProduct(request);
    }

    @GetMapping("/list")
    public ResponseEntity<Collection<Product>> listProduct(@RequestParam(defaultValue = "10") int limit){
        Collection<Product> product = productService.list(limit);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productID){
        Product product = productService.getProduct(productID);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int productID,
                                                 @RequestBody Product request){

        Product updatedProduct = productService.updateProduct(productID,request);
        if(updatedProduct == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProduct);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") int productID){
        Boolean product = productService.deleteProduct(productID);
        return ResponseEntity.ok(product);
    }
}
