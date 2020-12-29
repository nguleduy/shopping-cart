package com.example.cartservice.repository;

import com.example.cartservice.entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CartRepository extends JpaRepository<CartItemEntity, Long> {

  void deleteByProductId(Long productId);

  CartItemEntity findByProductId(Long productId);
}
