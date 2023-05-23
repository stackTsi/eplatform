package com.project.eplatform.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message ="Please input the product description!")
    private String productDesc;
    private Long price;
    private String productImgURL;



    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product", cascade = ALL)
    private List<Inventory> inventories = new ArrayList<>();

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
