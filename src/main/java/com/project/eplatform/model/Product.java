package com.project.eplatform.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int productID;
    @NotEmpty(message = "Please input the product name!")
    private String productName;
    @NotEmpty(message = "Please input the product description!")
    private String productDesc;
    @NotNull(message = "Please input the product price!")
    private Long price;
    private String productImgURL;

    @NotNull(message = "Please input the quantity to be added in stock!")
    private int quantityInStock;
    @ManyToOne
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = ALL)
    private List<ShoppingCart> shoppingCarts = new ArrayList<>();

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getProductImgURL() {
        return productImgURL;
    }

    public void setProductImgURL(String productImgURL) {
        this.productImgURL = productImgURL;
    }

}
