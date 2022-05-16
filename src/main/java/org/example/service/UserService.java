package org.example.service;

import org.example.domain.User;

import java.util.List;

public interface UserService {
    User insert(User user);

    List<User> getAll();

    User getById(int uid);

    User getByName(String username);

    User update(int id, String username, String password);

    void deleteById(int id);
}
