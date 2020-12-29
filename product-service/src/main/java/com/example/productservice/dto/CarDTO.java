package com.example.productservice.dto;

import com.example.productservice.entity.CarEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO extends ProductDTO{

  @NotNull
  @NotEmpty
  private double maxSpeed;

  @NotNull
  @NotEmpty
  private int nrOfSeats;

  public CarDTO(CarEntity carEntity) {
    super(carEntity.getId(),carEntity.getPrice(), carEntity.getCategory(), carEntity.getBrand(), carEntity.getModel(), carEntity.getWeight());
    this.maxSpeed = carEntity.getMaxSpeed();
    this.nrOfSeats = carEntity.getNrOfSeats();
  }
}
