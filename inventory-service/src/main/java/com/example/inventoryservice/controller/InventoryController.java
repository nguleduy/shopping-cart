package com.example.inventoryservice.controller;

import com.example.inventoryservice.dto.InventoryItemDTO;
import com.example.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

  @Autowired
  private InventoryService inventoryService;

  @PostMapping("/update")
  public boolean updateInventoryItemAmount(@RequestBody InventoryItemDTO inventoryItemDTO) {
    return inventoryService.updateInventoryItemAmount(inventoryItemDTO);
  }

  @PostMapping("/return")
  public boolean returnInventoryItem(@RequestBody InventoryItemDTO inventoryItemDTO) {
    return inventoryService.returnInventoryItem(inventoryItemDTO);
  }

  @GetMapping("/available/{productId}")
  boolean isProductAvailable(@PathVariable Long productId) {
    return inventoryService.isProductAvailable(productId);
  }
}
