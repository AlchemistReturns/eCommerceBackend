package com.abrar.store.services;

import com.abrar.store.dtos.AddItemToCartRequest;
import com.abrar.store.dtos.CartDto;
import com.abrar.store.dtos.CartItemDto;
import com.abrar.store.entities.Cart;
import com.abrar.store.entities.CartItem;
import com.abrar.store.entities.Product;
import com.abrar.store.exceptions.CartNotFoundException;
import com.abrar.store.exceptions.ProductNotFoundException;
import com.abrar.store.mappers.CartMapper;
import com.abrar.store.repositories.CartRepository;
import com.abrar.store.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartService {
    private CartRepository cartRepository;
    private CartMapper cartMapper;
    private ProductRepository productRepository;

    public CartDto createCart() {
        Cart cart = new Cart();
        cartRepository.save(cart);
        return cartMapper.toDto(cart);
    }

    public CartItemDto addToCart(UUID cartId, AddItemToCartRequest request) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null) {
            throw new CartNotFoundException();
        }
        Product product = productRepository.findById(request.getProductId()).orElse(null);
        if (product == null) {
            throw new ProductNotFoundException();
        }

        CartItem cartItem = cart.addItem(product);
        cartRepository.save(cart);

        return cartMapper.toDto(cartItem);
    }
}
