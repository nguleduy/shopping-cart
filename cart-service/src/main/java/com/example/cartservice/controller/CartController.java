package com.example.cartservice.controller;

import com.example.cartservice.dto.CartItemDTO;
import com.example.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CartController {

  @Autowired
  private CartService cartService;

  @PostMapping("/add")
  public ResponseEntity<String> addToCart(@RequestBody CartItemDTO cartItemDTO) {
    return cartService.addToCart(cartItemDTO);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<String> deleteFromCart(@RequestBody CartItemDTO cartItemDTO) {
    cartService.deleteFromCart(cartItemDTO);
    return new ResponseEntity<>("Product deleted from cart", HttpStatus.OK);
  }

  @GetMapping("/all")
  public List<CartItemDTO> getCartItems() {
    return cartService.getCartItems();
  }
}
