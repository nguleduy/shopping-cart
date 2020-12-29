package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.InventoryItemDTO;

public interface InventoryService {

  boolean updateInventoryItemAmount(InventoryItemDTO inventoryItemDTO);

  boolean returnInventoryItem(InventoryItemDTO inventoryItemDTO);
}
