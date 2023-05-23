package com.project.eplatform.service.implementation;

import com.project.eplatform.model.Orderline;
import com.project.eplatform.model.Product;
import com.project.eplatform.model.ShoppingCart;
import com.project.eplatform.repository.OrderlineRepository;
import com.project.eplatform.repository.ShoppingCartRepository;
import com.project.eplatform.service.OrderlineService;
import jakarta.persistence.criteria.Order;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class OrderlineServiceImpl implements OrderlineService {
    private final OrderlineRepository orderlineRepository;

}
