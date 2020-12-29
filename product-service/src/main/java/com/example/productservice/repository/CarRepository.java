package com.example.productservice.repository;

import com.example.productservice.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<CarEntity, Long> {

  List<CarEntity> findByModel(String model);
}
