package com.example.addressservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

  @GetMapping("/hello")
  public String sayHello() {
    return "hello";
  }
}
