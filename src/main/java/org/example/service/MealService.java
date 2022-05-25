package org.example.service;

import org.example.domain.Meal;
import org.example.domain.ProductItem;
import org.example.domain.User;

import java.util.List;

public interface MealService {

    List<ProductItem> getAll();

    Meal getById(int mealId);

    Meal insert(String name, int id, List<ProductItem> list);

    List<Meal> getByUserId(int id);

    void deleteMeal(String name);
}
