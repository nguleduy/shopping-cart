package com.example.productservice.service;

import com.example.productservice.dto.CarDTO;

import java.util.List;

public interface ProductService<T> {

  List<T> findAll();

  List<T> findByModel(String model);

  T findById(Long id);

  List<CarDTO> getAllAvailable();
}
