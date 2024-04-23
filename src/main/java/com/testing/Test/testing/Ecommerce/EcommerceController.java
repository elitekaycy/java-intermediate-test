package com.testing.Test.testing.Ecommerce;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ecommerce")
public class EcommerceController {

  private final EcommerceServiceImpl ecommerceService;

  public EcommerceController(EcommerceServiceImpl ecommerceService) {
    this.ecommerceService = ecommerceService;
  }

  @GetMapping("")
  public ResponseEntity<List<Product>> productBrowsing(@RequestParam(name = "q") String q) {

    List<Product> getProducts = ecommerceService.getProducts(q);

    return ResponseEntity.ok(getProducts);
  }

  @PostMapping("")
  public ResponseEntity<Product> placeProductOrder(@RequestBody Product product) {
    Product createProduct = ecommerceService.placeOrder(product);
    return ResponseEntity.ok(createProduct);
  }
}
