package com.project.eplatform.repository;

import com.project.eplatform.model.Orderline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderlineRepository extends JpaRepository<Orderline,Integer> {
}
