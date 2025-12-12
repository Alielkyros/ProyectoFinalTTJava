package com.techlab.speedrun.repository;

import com.techlab.speedrun.entity.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByDeletedFalse();
  Optional<Product> findByIdAndDeletedFalse(Long id);
  List<Product> findByTitleContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndDeletedFalse(String title, String category);
  List<Product> findByTitleContainingIgnoreCaseAndDeletedFalse(String title);
  List<Product> findByCategoryContainingIgnoreCaseAndDeletedFalse(String category);
}
