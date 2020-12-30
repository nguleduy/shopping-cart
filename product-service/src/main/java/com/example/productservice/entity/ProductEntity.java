package com.example.productservice.entity;

import com.example.productservice.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "products")
public class ProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private double price;

  @Enumerated(EnumType.STRING)
  private Category category;

  private String brand;

  private String model;

  private double weight;

  private String picture;

  public ProductEntity(String picture, double price, Category category, String brand, String model, double weight) {
    this.picture = picture;
    this.price = price;
    this.category = category;
    this.brand = brand;
    this.model = model;
    this.weight = weight;
  }
}
