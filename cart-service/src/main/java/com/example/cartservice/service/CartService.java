package com.example.cartservice.service;

import com.example.cartservice.dto.CartItemDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartService {

  ResponseEntity<String> addToCart(CartItemDTO cartItemDTO);

  List<CartItemDTO> getCartItems();

  void deleteFromCart(CartItemDTO cartItemDTO);
}
