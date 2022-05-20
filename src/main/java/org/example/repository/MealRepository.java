package org.example.repository;

import org.example.domain.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Integer> {

    List<Meal> findByUserId(int id);
}
