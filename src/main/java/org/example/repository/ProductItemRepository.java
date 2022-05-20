package org.example.repository;

import org.example.domain.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductItemRepository extends JpaRepository<ProductItem, Integer> {

    List<ProductItem> findByMealId(int id);
}
