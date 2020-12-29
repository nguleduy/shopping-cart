package com.example.inventoryservice.dto;

import com.example.inventoryservice.entity.InventoryItemEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryItemDTO {

  @NotNull
  @NotEmpty
  private Long productId;

  @NotNull
  @NotEmpty
  private int amount;

  public InventoryItemDTO(InventoryItemEntity inventoryItemEntity) {
    this.productId = inventoryItemEntity.getProductId();
    this.amount = inventoryItemEntity.getAmount();
  }
}
