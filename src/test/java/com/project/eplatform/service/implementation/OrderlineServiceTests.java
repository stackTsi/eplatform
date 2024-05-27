package com.project.eplatform.service.implementation;

import com.project.eplatform.model.Orderline;
import com.project.eplatform.model.Product;
import com.project.eplatform.repository.OrderlineRepository;
import com.project.eplatform.service.OrderlineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OrderlineServiceTests {

    @Autowired
    private OrderlineService orderlineService;

    @MockBean
    private OrderlineRepository orderlineRepository;

    private Orderline orderline;

    @BeforeEach
    public void setUp() {
        orderline= new Orderline();
        orderline.setOrderID(1);
        orderline.setSumPrice(1000L);
    }

    @Test
    public void testSaveOrderline() {
        // Mocking save method to return the orderline
        when(orderlineRepository.save(orderline)).thenReturn(orderline);

        // This should fail because save method in service returns null
        Orderline result = orderlineService.save(orderline);

        assertNotNull(result, "Expected result is not null due to the bug in save method");
    }

    @Test
    public void testGetOrderlineById() {
        // Mocking findById method to return an Optional of orderline
        when(orderlineRepository.findById(1)).thenReturn(Optional.of(orderline));

        // This should fail with NoSuchElementException due to get() without isPresent() check
        assertThrows(NoSuchElementException.class, () -> {
            orderlineService.getOrderlineById(1);
        });
    }

    @Test
    public void testGetAllOrderlines() {
        List<Orderline> orderlines = List.of(orderline);
        when(orderlineRepository.findAll()).thenReturn(orderlines);

        List<Orderline> result = orderlineService.getAllOrderlines();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.contains(orderline));
        verify(orderlineRepository, times(1)).findAll();
    }
}

