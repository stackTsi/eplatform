package com.project.eplatform.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Category {
    @NotEmpty(message = "Please input the category name")
    private String categoryName;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int categoryID;

    @ManyToOne
    @JoinColumn(name = "parent_categoryID")
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
    private List<Category> subcategories = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }
    // depending on future needs, will implement better "subcategory" getter and setter to display and pass to http endpoints
    // for now, removed those getter and setter to avoid stackoverflow from model conflicts.

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


}
