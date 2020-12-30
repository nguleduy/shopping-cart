package com.example.productservice.service.impl;

import com.example.productservice.communication.InventoryServiceCommunicator;
import com.example.productservice.dto.ProductDTO;
import com.example.productservice.entity.ProductEntity;
import com.example.productservice.enums.Category;
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

  @Autowired
  private InventoryServiceCommunicator inventoryServiceCommunicator;

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

  @Override
  public List<ProductDTO> getAllAvailable() {
    List<ProductEntity> productEntities = productRepository.findAll();
    return productEntities.stream()
            .map(product -> new ProductDTO(product))
            .filter(productTO -> inventoryServiceCommunicator.isProductAvailable(productTO.getId()))
            .collect(Collectors.toList());
  }

  @Override
  public List<ProductDTO> findByCategory(String category) {
    List<ProductEntity> productsEntities = productRepository.findByCategory(mapCategoryToEnum(category));

    return productsEntities.stream()
            .map(productEntity -> new ProductDTO(productEntity))
            .collect(Collectors.toList());
  }

  private Category mapCategoryToEnum(String category) {
    for (Category categoryEnum : Category.values()) {
      if (categoryEnum.toString().equals(category)) {
        return categoryEnum;
      }
    }
    return null;
  }
}
