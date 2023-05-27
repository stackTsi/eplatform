package com.project.eplatform.controller;

import com.project.eplatform.model.ShoppingCart;
import com.project.eplatform.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @PostMapping("/create")
    public ResponseEntity<?> createCart(@RequestBody ShoppingCart request){
        return shoppingCartService.createCart(request);
    }

    @GetMapping("/items/{cartId}")
    public ResponseEntity<ShoppingCart> getCartItemsById(@PathVariable("cartId") int cartId) {
        ShoppingCart cart = shoppingCartService.getCartItemsById(cartId);
        if (cart != null) {
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<Collection<ShoppingCart>> list(@RequestParam(defaultValue = "15") int limit){
        Collection<ShoppingCart> cart = shoppingCartService.list(limit);

        return ResponseEntity.ok(cart);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCart(@PathVariable("id")int cartID){
        Boolean cart = shoppingCartService.deleteCart(cartID);
        return ResponseEntity.ok(cart);
    }
}
