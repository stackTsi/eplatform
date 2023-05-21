package com.project.eplatform.repository;

import com.project.eplatform.model.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails,Integer> {
}
