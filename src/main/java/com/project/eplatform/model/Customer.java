package com.project.eplatform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int customerID;

    @NotEmpty(message="username cannot be empty")
    private String userName;
    @NotEmpty(message="password cannot be empty")
    private String password;
    private String fullName;
    @Column(unique = true)
    @NotEmpty(message="email cannot be empty")
    private String email;

    @Column(name = "is_sales_staff", columnDefinition = "boolean default false")
    private boolean isSalesStaff;

    @ManyToOne
    private Address address;

    @OneToMany(mappedBy = "customer", cascade = ALL)
    private List<PaymentDetails> paymentDetailsList;

//    @JsonIgnore
//    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
//    private List<ShoppingCart> shoppingCartList;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSalesStaff() {
        return isSalesStaff;
    }

    public void setSalesStaff(boolean salesStaff) {
        isSalesStaff = salesStaff;
    }
}
