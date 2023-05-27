package com.project.eplatform.service.implementation;

import com.project.eplatform.model.ShoppingCart;
import com.project.eplatform.repository.ShoppingCartRepository;
import com.project.eplatform.service.ShoppingCartService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    @Override
    public ResponseEntity<?> createCart(ShoppingCart request) {
        Map<String, Object> response = new HashMap<>();
        log.info("Adding a new Cart: {}", request.getCartID());

        //save the product to the repository
        shoppingCartRepository.save(request);

        //return the request on the API
        response.put("response", request);
        return ResponseEntity.ok(response);
    }

    @Override
    public Collection<ShoppingCart> list(int limit) {
        log.info("Fetching list of shopping carts");
        return shoppingCartRepository.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public ShoppingCart getCartItemsById(int cartID) {
        log.info("Fetching cart items by ID: {}", cartID);
        Optional<ShoppingCart> cartOptional = shoppingCartRepository.findById(cartID);
        return cartOptional.orElse(null);
    }

    @Override
    public Boolean deleteCart(int cartID) {
        log.info("Deleting cart by ID: {}",cartID);
        Optional<ShoppingCart> cart = shoppingCartRepository.findById(cartID);
        if(cart.isPresent()){
            shoppingCartRepository.deleteById(cartID);
            log.info("Cart deletion was a success!");
            return TRUE;
        } else {
            log.warn("Error! CartID {} not found!", cartID);
            return FALSE;
        }
    }
}
