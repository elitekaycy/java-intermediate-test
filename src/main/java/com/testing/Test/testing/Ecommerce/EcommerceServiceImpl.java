package com.testing.Test.testing.Ecommerce;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EcommerceServiceImpl {

  private static List<Product> products = List.of(
      new Product("tail", 23),
      new Product("head", 20));

  public EcommerceServiceImpl() {

  }

  public List<Product> getProducts(String q) {
    return products.stream().filter(product -> product.getName().contains(q)).toList();
  }

  public Product placeOrder(Product product) {
    products.add(product);
    return product;
  }
}
