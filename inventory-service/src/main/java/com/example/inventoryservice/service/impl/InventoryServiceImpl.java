package com.example.inventoryservice.service.impl;

import com.example.inventoryservice.dto.InventoryItemDTO;
import com.example.inventoryservice.entity.InventoryItemEntity;
import com.example.inventoryservice.repository.InventoryRepository;
import com.example.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

  @Autowired
  private InventoryRepository inventoryRepository;

  @Override
  public boolean updateInventoryItemAmount(InventoryItemDTO inventoryItemDTO) {
    InventoryItemEntity inventoryEntity = inventoryRepository.findByProductId(inventoryItemDTO.getProductId());

    if (inventoryItemDTO.getAmount() > inventoryEntity.getAmount()) {
      return false;
    }
    inventoryEntity.setAmount(inventoryEntity.getAmount() - inventoryItemDTO.getAmount());
    inventoryRepository.save(inventoryEntity);

    return true;
  }

  @Override
  public boolean returnInventoryItem(InventoryItemDTO inventoryItemDTO) {
    InventoryItemEntity inventoryEntity = inventoryRepository.findByProductId(inventoryItemDTO.getProductId());
    inventoryEntity.setAmount(inventoryEntity.getAmount() + inventoryItemDTO.getAmount());
    inventoryRepository.save(inventoryEntity);

    return true;
  }

  @Override
  public boolean isProductAvailable(Long productId) {
    return inventoryRepository.findByProductId(productId).getAmount() > 0;
  }
}
