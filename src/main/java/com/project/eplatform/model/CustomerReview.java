package com.project.eplatform.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cusreview")
public class CustomerReview {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int reviewID;
    @Min(0)
    @Max(5)
    private int rating;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "orderID")
    private Orderline order;

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
