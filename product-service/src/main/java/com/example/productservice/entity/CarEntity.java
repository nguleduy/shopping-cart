package com.example.productservice.entity;

import com.example.productservice.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class CarEntity extends ProductEntity {

  private double maxSpeed;

  private int nrOfSeats;

  public CarEntity(double price, Category category, String brand, String model, double weight, double maxSpeed,
                   int nrOfSeats) {
    super(price, category, brand, model, weight);
    this.maxSpeed = maxSpeed;
    this.nrOfSeats = nrOfSeats;
  }
}
