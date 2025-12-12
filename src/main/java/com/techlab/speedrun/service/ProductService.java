package com.techlab.speedrun.service;

import com.techlab.speedrun.entity.Product;
import com.techlab.speedrun.exception.ResourceNotFoundException;
import com.techlab.speedrun.repository.ProductRepository;
import com.techlab.speedrun.utils.StringUtils;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;
  private final StringUtils stringUtils;

  public ProductService(ProductRepository productRepository, StringUtils stringUtils) {
    this.productRepository = productRepository;
    this.stringUtils = stringUtils;
  }

  public Product createProduct(Product product) {
    if (product.getPrice() == null || product.getPrice() < 0) {
      throw new IllegalArgumentException("Precio inválido");
    }
    return this.productRepository.save(product);
  }

  public Product getProductById(Long id) {
    Optional<Product> productOptional = this.productRepository.findByIdAndDeletedFalse(id);
    if (productOptional.isEmpty()) {
      throw new ResourceNotFoundException("Producto no encontrado con ID: " + id);
    }
    return productOptional.get();
  }

  public List<Product> findAllProducts(String title, String category) {
    if (!title.isEmpty() && !category.isEmpty()) {
      return this.productRepository.findByTitleContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndDeletedFalse(title, category);
    }
    if (!title.isEmpty()) {
      return this.productRepository.findByTitleContainingIgnoreCaseAndDeletedFalse(title);
    }
    if (!category.isEmpty()) {
      return this.productRepository.findByCategoryContainingIgnoreCaseAndDeletedFalse(category);
    }
    return this.productRepository.findByDeletedFalse();
  }

  public Product editProductById(Long id, Product dataToEdit) {
    Product product = this.getProductById(id);
    if (!stringUtils.isEmpty(dataToEdit.getTitle())) {
      product.setTitle(dataToEdit.getTitle());
    }
    if (dataToEdit.getPrice() != null) {
      product.setPrice(dataToEdit.getPrice());
    }
    if (dataToEdit.getStock() != null) {
      product.setStock(dataToEdit.getStock());
    }
    if (!stringUtils.isEmpty(dataToEdit.getCategory())) {
      product.setCategory(dataToEdit.getCategory());
    }
    if (!stringUtils.isEmpty(dataToEdit.getImage())) {
      product.setImage(dataToEdit.getImage());
    }
    if (dataToEdit.getDeleted() != null) {
      product.setDeleted(dataToEdit.getDeleted());
    }
    return this.productRepository.save(product);
  }

  public Product deleteProductById(Long id) {
    Product product = this.getProductById(id);
    product.setDeleted(true);
    product.setDeletedDate(LocalDate.now());
    this.productRepository.save(product);
    return product;
  }
}
