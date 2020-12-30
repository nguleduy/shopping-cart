package com.example.productservice.repository;

import com.example.productservice.entity.ProductEntity;
import com.example.productservice.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

  List<ProductEntity> findByModel(String model);

  List<ProductEntity> findByCategory(Category category);
}
