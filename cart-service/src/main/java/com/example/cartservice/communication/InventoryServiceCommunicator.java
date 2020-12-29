package com.example.cartservice.communication;

import com.example.cartservice.dto.CartItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("inventory-service")
@RequestMapping("/inventory")
public interface InventoryServiceCommunicator {

  @PostMapping("/update")
  public boolean updateInventoryItemAmount(@RequestBody CartItemDTO cartItemDTO);

  @PostMapping("/return")
  public boolean returnInventoryItem(@RequestBody CartItemDTO cartItemDTO);
}
