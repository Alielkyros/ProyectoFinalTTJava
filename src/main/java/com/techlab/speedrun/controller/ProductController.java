package com.techlab.speedrun.controller;

import com.techlab.speedrun.entity.Product;
import com.techlab.speedrun.service.ProductService;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping
  public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    Product created = this.productService.createProduct(product);
    return ResponseEntity.created(URI.create("/products/" + created.getId())).body(created);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable Long id) {
    Product p = this.productService.getProductById(id);
    return ResponseEntity.ok(p);
  }

  @GetMapping
  public ResponseEntity<List<Product>> getAllProducts(
      @RequestParam(required = false, defaultValue = "") String name,
      @RequestParam(required = false, defaultValue = "") String category) {
    return ResponseEntity.ok(this.productService.findAllProducts(name, category));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> editProductById(@PathVariable Long id, @RequestBody Product dataToEdit) {
    Product updated = this.productService.editProductById(id, dataToEdit);
    return ResponseEntity.ok(updated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
    this.productService.deleteProductById(id);
    return ResponseEntity.noContent().build();
  }
}
