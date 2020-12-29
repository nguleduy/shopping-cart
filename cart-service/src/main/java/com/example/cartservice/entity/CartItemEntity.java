package com.example.cartservice.entity;

import com.example.cartservice.dto.CartItemDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
public class CartItemEntity {

  @Id
  @GeneratedValue
  private Long id;

  private Long productId;

  private int amount;

  public CartItemEntity(CartItemDTO cartItemDTO) {
    this.productId = cartItemDTO.getProductId();
    this.amount = cartItemDTO.getAmount();
  }
}
