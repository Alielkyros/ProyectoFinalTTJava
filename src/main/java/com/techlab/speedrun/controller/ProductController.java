package com.techlab.speedrun.controller;

import com.techlab.speedrun.controller.response.ApiResponse;
import com.techlab.speedrun.entity.Product;
import com.techlab.speedrun.service.ProductService;

import java.net.URI;
import java.time.LocalDateTime;
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

  // ✅ CREATE
  @PostMapping
  public ResponseEntity<ApiResponse> createProduct(@RequestBody Product product) {

    Product created = this.productService.createProduct(product);

    return ResponseEntity
        .created(URI.create("/products/" + created.getId()))
        .body(
            new ApiResponse(
                true,
                "Producto: " + created.getTitle() + " con id: " + created.getId() + " creado con éxito",
                LocalDateTime.now()
            )
        );
  }

  // 🔍 GET BY ID (sin mensaje, devuelve entidad)
  @GetMapping("/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable Long id) {
    Product p = this.productService.getProductById(id);
    return ResponseEntity.ok(p);
  }

  // 📋 GET ALL
  @GetMapping
  public ResponseEntity<List<Product>> getAllProducts(
      @RequestParam(required = false, defaultValue = "") String name,
      @RequestParam(required = false, defaultValue = "") String category) {

    return ResponseEntity.ok(this.productService.findAllProducts(name, category));
  }

  // ✏️ EDIT
  @PutMapping("/{id}")
  public ResponseEntity<ApiResponse> editProductById(
      @PathVariable Long id,
      @RequestBody Product dataToEdit) {

    Product updated = this.productService.editProductById(id, dataToEdit);

    return ResponseEntity.ok(
        new ApiResponse(
            true,
            "Se editó correctamente el producto " + updated.getTitle() + " con id: " + updated.getId(),
            LocalDateTime.now()
        )
    );
  }

  // 🗑️ DELETE (soft delete)
  @DeleteMapping("/{id}")
  public ResponseEntity<ApiResponse> deleteProductById(@PathVariable Long id) {

    Product deleted = this.productService.deleteProductById(id);

    return ResponseEntity.ok(
        new ApiResponse(
            true,
            "El producto " + deleted.getTitle() + " con id: " + deleted.getId() + " fue borrado con éxito",
            LocalDateTime.now()
        )
    );
  }
}
