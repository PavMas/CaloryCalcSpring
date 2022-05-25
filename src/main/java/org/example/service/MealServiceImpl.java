package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Meal;
import org.example.domain.Product;
import org.example.domain.ProductItem;
import org.example.domain.User;
import org.example.repository.MealRepository;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService{
    private final MealRepository mealRepository;
    private final UserRepository userRepository;

    @Override
    public List<ProductItem> getAll() {
        return null;
    }

    @Override
    public Meal getById(int mealId) {
        return mealRepository.getById(mealId);
    }

    @Override
    public Meal insert(final String name, final int id, final List<ProductItem> list) {
        User user = userRepository.findById(id);
        float totalWeight = 0;
        for(ProductItem item : list)
            totalWeight += item.getWeight();
        Meal meal = Meal.builder()
                .name(name)
                .user(user)
                .productItems(list)
                .totalWeight(totalWeight)
                .build();
        return mealRepository.save(meal);
    }

    @Override
    public List<Meal> getByUserId(int id) {
        return mealRepository.findByUserId(id);
    }

    @Override
    public void deleteMeal(String name) {
        mealRepository.deleteByName(name);
    }
}
