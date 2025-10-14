package com.abrar.store.controllers;

import com.abrar.store.dtos.AddItemToCartRequest;
import com.abrar.store.dtos.CartDto;
import com.abrar.store.dtos.CartItemDto;
import com.abrar.store.dtos.UpdateCartItemRequest;
import com.abrar.store.entities.Cart;
import com.abrar.store.entities.CartItem;
import com.abrar.store.entities.Product;
import com.abrar.store.mappers.CartMapper;
import com.abrar.store.repositories.CartRepository;
import com.abrar.store.repositories.ProductRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.image.ReplicateScaleFilter;
import java.net.URI;
import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/carts")
public class CartController {
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<CartDto> createCart(
            UriComponentsBuilder uriBuilder
    ) {
        Cart cart = new Cart();
        cartRepository.save(cart);
        CartDto cartDto = cartMapper.toDto(cart);
        URI uri = uriBuilder.path("/carts/{id}").buildAndExpand(cartDto.getId()).toUri();

        return ResponseEntity.created(uri).body(cartDto);
    }

    @PostMapping("/{cartId}/items")
    public ResponseEntity<CartItemDto> addToCart(@PathVariable(name = "cartId") UUID cartId,
                                                 @RequestBody AddItemToCartRequest request) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null) {
            return ResponseEntity.notFound().build();
        }
        Product product = productRepository.findById(request.getProductId()).orElse(null);
        if (product == null) {
            return ResponseEntity.badRequest().build();
        }

        CartItem cartItem = cart.addItem(product);
        cartRepository.save(cart);

        CartItemDto cartItemDto = cartMapper.toDto(cartItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartItemDto);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<CartDto> getCart(@PathVariable(name = "cartId") UUID cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cartMapper.toDto(cart));
    }

    @PutMapping("/{cartId}/items/{productId}")
    public ResponseEntity<?> updateCart(@PathVariable UUID cartId, @PathVariable Long productId,
                                                  @Valid @RequestBody UpdateCartItemRequest request) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    Map.of("error", "Cart not found")
            );
        }
        CartItem cartItem = cart.getItem(productId);

        if (cartItem == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    Map.of("error", "Cart item not found")
            );
        }

        cartItem.setQuantity(request.getQuantity());
        cartRepository.save(cart);

        return ResponseEntity.ok(cartMapper.toDto(cartItem));
    }
}
