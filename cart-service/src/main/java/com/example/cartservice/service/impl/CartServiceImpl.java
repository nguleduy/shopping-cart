package com.example.cartservice.service.impl;

import com.example.cartservice.communication.InventoryServiceCommunicator;
import com.example.cartservice.communication.ProductServiceCommunicator;
import com.example.cartservice.dto.CartItemDTO;
import com.example.cartservice.entity.CartItemEntity;
import com.example.cartservice.repository.CartRepository;
import com.example.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

  @Autowired
  private CartRepository cartRepository;

  @Autowired
  private ProductServiceCommunicator productServiceCommunicator;

  @Autowired
  private InventoryServiceCommunicator inventoryServiceCommunicator;

  @Override
  public ResponseEntity<String> addToCart(CartItemDTO cartItemDTO) {
    if (!productServiceCommunicator.isProductWithIdExist(cartItemDTO.getProductId())) {
      return new ResponseEntity<>("Product with id: " + cartItemDTO.getProductId() + " does not exist", HttpStatus.NOT_FOUND);
    }
    if (!inventoryServiceCommunicator.returnInventoryItem(cartItemDTO)) {
      return new ResponseEntity<>("There is no enough products in database", HttpStatus.CONFLICT);
    }

    CartItemEntity cartItem = cartRepository.findByProductId(cartItemDTO.getProductId());

    if (cartItem != null) {
      cartItem.setAmount(cartItem.getAmount() + cartItemDTO.getAmount());
      cartRepository.save(cartItem); // check if without works
    } else {
      cartRepository.save(new CartItemEntity(cartItemDTO));
    }

    return new ResponseEntity<>("Product added to cart", HttpStatus.CREATED);
  }

  @Override
  public List<CartItemDTO> getCartItems() {
    return cartRepository.findAll()
            .stream()
            .map(cartItem -> new CartItemDTO(cartItem))
            .collect(Collectors.toList());
  }

  @Override
  public void deleteFromCart(CartItemDTO cartItemDTO) {
    inventoryServiceCommunicator.returnInventoryItem(cartItemDTO);

    CartItemEntity cartItem = cartRepository.findByProductId(cartItemDTO.getProductId());
    if (cartItem.getAmount() == cartItemDTO.getAmount()) {
      cartRepository.deleteByProductId(cartItemDTO.getProductId());
    } else {
      cartItem.setAmount(cartItem.getAmount() - cartItemDTO.getAmount());
      cartRepository.save(cartItem);
    }
  }
}
