package com.example.productservice;

import com.example.productservice.entity.CarEntity;
import com.example.productservice.enums.Category;
import com.example.productservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

  @Autowired
  private CarRepository carRepository;

  public static void main(String[] args) {
    SpringApplication.run(ProductServiceApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    carRepository.save(new CarEntity(10000.0, Category.CAR, "BMW", "X5", 2700, 248, 5));
    carRepository.save(new CarEntity(13000.0, Category.CAR, "BMW", "Z3", 1700, 290, 2));
    carRepository.save(new CarEntity(14000.0, Category.CAR, "Audi", "S5", 2300, 280, 4));
    carRepository.save(new CarEntity(50000.0, Category.CAR, "Ferrari", "X5", 1900, 320, 2));
  }
}
