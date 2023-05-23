package com.project.eplatform.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class Orderline {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int orderID;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date orderDate;

    private Long sumPrice;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<CustomerReview> customerReviews;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<PaymentDetails> paymentDetailsList;

    @ManyToOne
    private ShoppingCart shoppingCart;
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Long getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Long sumPrice) {
        this.sumPrice = sumPrice;
    }
}
