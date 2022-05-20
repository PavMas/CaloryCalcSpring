package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Meal;
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
    public Meal insert(final String name, final int id, final List<ProductItem> list) {
        User user = userRepository.findById(id);
        Meal meal = Meal.builder()
                .name(name)
                .user(user)
                .productItems(list)
                .build();
        return mealRepository.save(meal);
    }

    @Override
    public List<Meal> getByUserId(int id) {
        return mealRepository.findByUserId(id);
    }
}
