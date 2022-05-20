package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.ProductItem;

import org.example.repository.ProductItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductItemServiceImpl implements ProductItemService{
    final ProductItemRepository productItemRepository;
    final MealService mealService;
    @Override
    public List<ProductItem> insert(List<ProductItem> list, int mealId) {
        for (ProductItem item : list) {
            item.setMeal(mealService.getById(mealId));
            productItemRepository.save(item);
        }
        return list;
    }

    @Override
    public List<ProductItem> getByMealId(int id) {
        return null;
    }
}
