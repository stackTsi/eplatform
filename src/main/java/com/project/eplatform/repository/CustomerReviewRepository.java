package com.project.eplatform.repository;

import com.project.eplatform.model.CustomerReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerReviewRepository extends JpaRepository<CustomerReview, Integer> {
}
