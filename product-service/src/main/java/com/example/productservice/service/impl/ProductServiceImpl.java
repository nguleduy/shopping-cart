package com.example.productservice.service.impl;

import com.example.productservice.dto.ProductDTO;
import com.example.productservice.entity.ProductEntity;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService<ProductDTO> {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public List<ProductDTO> findAll() {

    List<ProductEntity> productEntities = productRepository.findAll();

    return productEntities.stream()
            .map(product -> new ProductDTO(product))
            .collect(Collectors.toList());
  }

  @Override
  public List<ProductDTO> findByModel(String model) {
    List<ProductEntity> productEntities = productRepository.findByModel(model);

    return productEntities.stream()
            .map(product -> new ProductDTO(product))
            .collect(Collectors.toList());
  }

  @Override
  public ProductDTO findById(Long id) {
    ProductEntity product = productRepository.findById(id).orElse(new ProductEntity());

    return new ProductDTO(product);
  }
}
