package com.example.productservice.service.impl;

import com.example.productservice.communication.InventoryServiceCommunicator;
import com.example.productservice.dto.CarDTO;
import com.example.productservice.entity.CarEntity;
import com.example.productservice.repository.CarRepository;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements ProductService<CarDTO> {

  @Autowired
  private CarRepository carRepository;

  @Autowired
  private InventoryServiceCommunicator inventoryServiceCommunicator;

  @Override
  public List<CarDTO> findAll() {

    List<CarEntity> cartEntities = carRepository.findAll();

    return cartEntities.stream()
            .map(car -> new CarDTO(car))
            .collect(Collectors.toList());
  }

  @Override
  public List<CarDTO> findByModel(String model) {
    List<CarEntity> cartEntities = carRepository.findByModel(model);

    return cartEntities.stream()
            .map(car -> new CarDTO(car))
            .collect(Collectors.toList());
  }

  @Override
  public CarDTO findById(Long id) {
    CarEntity car = carRepository.findById(id).orElse(new CarEntity());

    return new CarDTO(car);
  }

  @Override
  public List<CarDTO> getAllAvailable() {
    List<CarEntity> cartEntities = carRepository.findAll();

    return cartEntities.stream()
            .map(car -> new CarDTO(car))
            .filter(car -> inventoryServiceCommunicator.isProductAvailable(car.getId()))
            .collect(Collectors.toList());
  }

  @Override
  public List<CarDTO> findByCategory(String category) {
    // TODO Auto-generated method stub
    return null;
  }
}
