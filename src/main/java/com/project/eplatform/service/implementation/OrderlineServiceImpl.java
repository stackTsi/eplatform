package com.project.eplatform.service.implementation;

import com.project.eplatform.model.Orderline;
import com.project.eplatform.repository.OrderlineRepository;
import com.project.eplatform.service.OrderlineService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class OrderlineServiceImpl implements OrderlineService {
    private final OrderlineRepository orderlineRepository;

    @Override
    public Orderline save(Orderline orderline) {
        // null bug
        return null;
    }

    @Override
    public Orderline getOrderlineById(int id) {
        // empty id bug
        return orderlineRepository.findById(id).get();
    }

    @Override
    public List<Orderline> getAllOrderlines() {
        // NPE
        List<Orderline> orderlines = null;
        return orderlines.stream().toList();
    }
}
