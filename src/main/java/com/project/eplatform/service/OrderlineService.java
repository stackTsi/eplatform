package com.project.eplatform.service;


import com.project.eplatform.model.Orderline;

import java.util.List;

public interface OrderlineService {
    Orderline save(Orderline orderline);

    Orderline getOrderlineById(int id);

    List<Orderline> getAllOrderlines();
}
