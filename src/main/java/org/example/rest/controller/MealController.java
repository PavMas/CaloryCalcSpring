package org.example.rest.controller;


import lombok.RequiredArgsConstructor;
import org.example.domain.Meal;
import org.example.domain.MealResponse;
import org.example.domain.ProductItem;
import org.example.domain.User;
import org.example.rest.dto.MealDto;
import org.example.service.MealService;
import org.example.service.ProductItemService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MealController {

    private final MealService mealService;
    private final ProductItemService productItemService;

    @PostMapping("/meal")
    public MealDto addMeal(@RequestBody MealResponse meal1){
        Meal meal = mealService.insert(meal1.getName(), meal1.getUid(), meal1.getList());
        productItemService.insert(meal.getProductItems(), meal.getId());
        return MealDto.toDto(meal);
    }
    @GetMapping("/user/{id}/meals")
    public List<MealDto> getMeals(@PathVariable int id){
        return mealService.getByUserId(id).stream().map(MealDto::toDto).collect(Collectors.toList());
    }

    @DeleteMapping("meal/{name}")
    @Transactional
    public void deleteMeal(@PathVariable String name){
        mealService.deleteMeal(name);
    }
}
