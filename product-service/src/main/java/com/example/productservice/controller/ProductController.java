package com.example.productservice.controller;

import com.example.productservice.dto.ProductDTO;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins ="http://localhost:4200", allowedHeaders= "*")
public class ProductController {

  @Autowired
  ProductService<ProductDTO> productService;

  @GetMapping("/check/{id}")
  public boolean isProductWithIdExist(@PathVariable Long id) {
    return productService.findById(id).getId() != null;
  }

  @GetMapping("/category/{category}")
  public List<ProductDTO> getByCategory(@PathVariable String category) {

    List<ProductDTO> products = productService.findByCategory(category);

    return products;
  }
}
