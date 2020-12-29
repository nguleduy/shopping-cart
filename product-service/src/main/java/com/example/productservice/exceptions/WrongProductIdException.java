package com.example.productservice.exceptions;

public class WrongProductIdException extends Exception {

  private static final long serialVersionUID = 1L;

  public WrongProductIdException(Long id) {
    super("No product with id: " + id);
  }
}
