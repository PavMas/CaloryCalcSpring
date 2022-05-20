package org.example.service;

import org.example.domain.Meal;
import org.example.domain.User;

import java.util.List;

public interface UserService {
    User insert(String name, String password);

    List<User> getAll();

    User getById(int uid);

    User getByName(String username);

    User update(int id, String username, String password);

    void deleteById(int id);

    List<Meal> getMeals(String username);
}
