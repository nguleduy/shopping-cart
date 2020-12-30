package com.example.productservice.communication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("inventory-service")
@RequestMapping("/inventory")
public interface InventoryServiceCommunicator {

  @GetMapping("/available/{productId}")
  boolean isProductAvailable(@PathVariable Long productId);
}
