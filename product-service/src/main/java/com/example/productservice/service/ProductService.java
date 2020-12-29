package com.example.productservice.service;

import java.util.List;

public interface ProductService<T> {

  List<T> findAll();

  List<T> findByModel(String model);

  T findById(Long id);
}
