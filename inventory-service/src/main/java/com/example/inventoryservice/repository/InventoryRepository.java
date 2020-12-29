package com.example.inventoryservice.repository;

import com.example.inventoryservice.entity.InventoryItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryItemEntity, Long> {

  InventoryItemEntity findByProductId(Long productId);
}
