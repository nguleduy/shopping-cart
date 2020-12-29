package com.example.cartservice.dto;

import com.example.cartservice.entity.CartItemEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {

  @NotNull
  @NotEmpty
  private Long productId;

  @NotNull
  @NotEmpty
  private int amount;

  public CartItemDTO(CartItemEntity cartItemEntity) {
    this.productId = cartItemEntity.getProductId();
    this.amount = cartItemEntity.getAmount();
  }
}
