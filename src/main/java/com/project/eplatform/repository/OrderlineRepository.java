package com.project.eplatform.repository;

import com.project.eplatform.model.Orderline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderlineRepository extends JpaRepository<Orderline,Integer> {
}
