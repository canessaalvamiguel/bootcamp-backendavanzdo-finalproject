package dev.canessaalvamiguel.serviceproducts.controller;

import dev.canessaalvamiguel.serviceproducts.entities.Product;
import dev.canessaalvamiguel.serviceproducts.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
@AllArgsConstructor
public class ProductController {

  ProductService productService;

  @GetMapping
  public ResponseEntity<List<Product>> getProducts(){
    log.info("Getting all products");
    return ResponseEntity.ok(productService.getProducts());
  }

  @GetMapping("/{productId}")
  public ResponseEntity<Product> getProductById(@PathVariable Long productId){
    log.info("Getting product by id: {}", productId);
    return ResponseEntity.ok(productService.getProductById(productId));
  }

  @PostMapping
  public ResponseEntity<Product> createProduct(@RequestBody Product product){
    log.info("Creating new product: {}", product);
    return ResponseEntity.ok(productService.createProduct(product));
  }

  @GetMapping("/company/{companyId}")
  public ResponseEntity<List<Product>> getProductsByCompanyId(@PathVariable Long companyId){
    log.info("Getting products by company id: {}", companyId);
    return ResponseEntity.ok(productService.getProductsByCompanyId(companyId));
  }
}
