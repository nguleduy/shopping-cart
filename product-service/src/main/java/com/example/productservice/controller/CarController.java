package com.example.productservice.controller;

import com.example.productservice.dto.CarDTO;
import com.example.productservice.exceptions.WrongProductIdException;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

  @Autowired
  ProductService<CarDTO> carService;

  @GetMapping("/all")
  public List<CarDTO> getAll() {
    return carService.findAll();
  }

  @GetMapping("/model/{model}")
  public List<CarDTO> getByModel(@PathVariable String model) {
    return carService.findByModel(model);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CarDTO> getById(@PathVariable Long id) throws WrongProductIdException {

    CarDTO car = carService.findById(id);

    if (car.getId() != null) {
      return new ResponseEntity<CarDTO>(car, HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
