package com.project.eplatform.controller;


import com.project.eplatform.model.Category;
import com.project.eplatform.model.Product;
import com.project.eplatform.service.CategoryService;
import com.project.eplatform.service.FileStorageService;
import com.project.eplatform.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final FileStorageService fileStorageService;
    private final CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@ModelAttribute Product request,
                                           @RequestParam(value="productImage") MultipartFile image) throws IOException{
        String imageURL = fileStorageService.saveFile(image);
        request.setProductImgURL("http://localhost:8080/product/images"+imageURL);
        return productService.createProduct(request);
    }

    @GetMapping("/list")
    public ResponseEntity<Collection<Product>> listProduct(@RequestParam(defaultValue = "35") int limit){
        Collection<Product> product = productService.list(limit);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/listcategory")
    public ResponseEntity<Collection<Product>> listIpad(@RequestParam(defaultValue = "10") int limit){
        Collection<Product> ipadProduct = productService.listIPad(limit);
        return ResponseEntity.ok(ipadProduct);
    }

    @GetMapping("/listiphone")
    public ResponseEntity<Collection<Product>> listIPhone(@RequestParam(defaultValue = "10") int limit){
        Collection<Product> iphoneProduct = productService.listIPhone(limit);
        return ResponseEntity.ok(iphoneProduct);
    }
    @GetMapping("/listmac")
    public ResponseEntity<Collection<Product>> listMac(@RequestParam(defaultValue = "10") int limit){
        Collection<Product> macProduct = productService.listMac(limit);
        return ResponseEntity.ok(macProduct);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productID){
        Product product = productService.getProduct(productID);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/update/{id}") // work in progress
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

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("/images/{fileName}")
    public ResponseEntity<Resource> getImage(@PathVariable String fileName) throws FileNotFoundException {
        // Load the image file from the specified directory
        Resource file = fileStorageService.loadFileAsResource(fileName);

        // Return the file contents in the response
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(file);
    }
}
