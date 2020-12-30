package com.example.productservice.controller;

import com.example.productservice.enums.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CategoryController {

  @GetMapping("/all")
  public List<String> getCategories() {
    return Arrays.asList(Category.values()).stream()
            .map(category -> category.toString())
            .collect(Collectors.toList());

  }
}
