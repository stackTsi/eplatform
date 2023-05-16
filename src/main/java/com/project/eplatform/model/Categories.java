package com.project.eplatform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Categories {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int categoryID;

    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "parent_categoryID")
    private Categories parentCategory;

    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
    private List<Categories> subcategories = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Categories getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Categories parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Categories> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Categories> subcategories) {
        this.subcategories = subcategories;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
