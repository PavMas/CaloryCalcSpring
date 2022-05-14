package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;


    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(int uid) {
        return userRepository.findById(uid);
    }

    @Override
    public User getByName(String username) {
        return userRepository.findByName(username);
    }

    @Override
    public User update(int id, String username, String password) {
        User user = User.builder().id(id).name(username).password(password).build();

        return userRepository.save(user);
    }

    @Override
    public void deleteById(int uid) {
        userRepository.deleteById(uid);
    }
}
