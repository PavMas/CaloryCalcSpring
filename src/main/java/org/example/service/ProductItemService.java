package org.example.service;

import org.example.domain.ProductItem;

import java.util.List;

public interface ProductItemService {

    List<ProductItem> insert(List<ProductItem> items, int mealId);

    List<ProductItem> getByMealId(int id);

}
