package com.example.productservice.dto;

import com.example.productservice.entity.ProductEntity;
import com.example.productservice.enums.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

  private Long id;

  @NotNull
  @NotEmpty
  private double price;

  @NotNull
  @NotEmpty
  private Category category;

  @NotNull
  @NotEmpty
  private String brand;

  @NotNull
  @NotEmpty
  private String model;

  @NotNull
  @NotEmpty
  private double weight;

  public ProductDTO(Long id, double price, Category category,
                    String brand, String model, double weight) {
    this.id = id;
    this.price = price;
    this.category = category;
    this.brand = brand;
    this.model = model;
    this.weight = weight;
  }

  public ProductDTO(ProductEntity productEntity) {
    this.id = productEntity.getId();
    this.price = productEntity.getPrice();
    this.category = productEntity.getCategory();
    this.brand = productEntity.getBrand();
    this.model = productEntity.getModel();
    this.weight = productEntity.getWeight();
  }
}
