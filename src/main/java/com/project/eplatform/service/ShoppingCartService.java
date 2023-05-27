package com.project.eplatform.service;


import com.project.eplatform.model.ShoppingCart;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface ShoppingCartService {
    ResponseEntity<?> createCart(ShoppingCart request);
    Collection<ShoppingCart> list(int limit);
    ShoppingCart getCartItemsById(int cartID);
    Boolean deleteCart(int cartID);
}
