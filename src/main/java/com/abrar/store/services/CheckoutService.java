package com.abrar.store.services;

import com.abrar.store.dtos.CheckoutRequest;
import com.abrar.store.dtos.CheckoutResponse;
import com.abrar.store.entities.Order;
import com.abrar.store.exceptions.CartEmptyException;
import com.abrar.store.exceptions.CartNotFoundException;
import com.abrar.store.repositories.CartRepository;
import com.abrar.store.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CheckoutService {
    private final CartRepository cartRepository;
    private final AuthService authService;
    private final OrderRepository orderRepository;
    private final CartService cartService;


    public CheckoutResponse checkout(CheckoutRequest request) {
        var cart = cartRepository.findById(request.getCartId()).orElse(null);
        if (cart == null) {
            throw new CartNotFoundException();
        }

        if (cart.isEmpty()) {
            throw new CartEmptyException();
        }

        var order = Order.fromCart(cart, authService.getCurrentUser());

        orderRepository.save(order);
        cartService.clearCart(cart.getId());

        return new CheckoutResponse(order.getId());
    }
}
